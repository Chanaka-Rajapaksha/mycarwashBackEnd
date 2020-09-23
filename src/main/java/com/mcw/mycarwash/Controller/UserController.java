package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Model.Client;
import com.mcw.mycarwash.Model.User;
import com.mcw.mycarwash.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userapi")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getClientList() {
        return userService.getUserList();
    }

    @PostMapping("/user")
    public User Save(@RequestBody User user){
        userService.saveUser(user);
        return  user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id){

        return userService.get(id);

    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "User deleted" + id;
    }
}
