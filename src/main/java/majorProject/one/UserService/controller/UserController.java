package majorProject.one.UserService.controller;

import majorProject.one.UserService.entities.UserServiceRequest;
import majorProject.one.UserService.manager.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    void create(@RequestBody UserServiceRequest userServiceRequest){
        userService.createUser(userServiceRequest);
    }

    @GetMapping("/user/{username}")
    ResponseEntity get(@PathVariable("username") String username){
        return ResponseEntity.ok(userService.get(username));
    }
}
