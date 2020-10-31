package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Exceptions.ResourceNotFoundException;
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
        if (!userService.getUserList().isEmpty()) {
            return userService.getUserList();
        } else {
            throw new ResourceNotFoundException("No users in the system");
        }
    }

    @PostMapping("/user")
    public User Save(@RequestBody User user) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {

        }
        return user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        if (userService.get(id) != null) {
            return userService.get(id);
        } else {
            throw new ResourceNotFoundException("User not found like " + id);
        }
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "User deleted" + id;
    }


}
