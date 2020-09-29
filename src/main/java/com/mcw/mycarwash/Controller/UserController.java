package com.mcw.mycarwash.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcw.mycarwash.Exceptions.CustomerNotFound;
import com.mcw.mycarwash.Model.Customer;
import com.mcw.mycarwash.Model.User;
import com.mcw.mycarwash.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public User Save(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {

        return userService.get(id);

    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "User deleted" + id;
    }

    @PostMapping("/userlogin")
    public String checkuser(@RequestBody User user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User newuser = userService.logingCheck(user);
            if(newuser.getUserId()==0){
                HashMap<String, String> responseMap = new HashMap<>();
                responseMap.put("status", "404");
                responseMap.put("message", "Not Found");
                String jsonString = objectMapper.writeValueAsString(responseMap);
                return jsonString;
            }else{
                String jsonString = objectMapper.writeValueAsString(newuser);
                return jsonString;
            }
        } catch (CustomerNotFound ex) {
            HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "404");
            responseMap.put("message", ex.getMessage());
            String jsonString = objectMapper.writeValueAsString(responseMap);
            return jsonString;
        } catch (JsonProcessingException ex) {
            HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "404");
            responseMap.put("message", ex.getMessage());
            String jsonString = objectMapper.writeValueAsString(responseMap);
            return jsonString;
        }
    }
    @PostMapping("/userloginnew")
    public String checkusernew(@RequestBody User user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User newuser = userService.logingCheck(user);
            if(newuser.getUserId()==0){
                HashMap<String, String> responseMap = new HashMap<>();
                responseMap.put("status", "404");
                responseMap.put("message", "Not Found");
                String jsonString = objectMapper.writeValueAsString(responseMap);
                return jsonString;
            }else{
                String jsonString = objectMapper.writeValueAsString(newuser);
                return jsonString;
            }
        } catch (CustomerNotFound ex) {
            HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "404");
            responseMap.put("message", ex.getMessage());
            String jsonString = objectMapper.writeValueAsString(responseMap);
            return jsonString;
        } catch (JsonProcessingException ex) {
            HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("status", "404");
            responseMap.put("message", ex.getMessage());
            String jsonString = objectMapper.writeValueAsString(responseMap);
            return jsonString;
        }
    }
}
