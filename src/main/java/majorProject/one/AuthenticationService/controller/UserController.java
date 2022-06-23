package majorProject.one.AuthenticationService.controller;

import majorProject.one.AuthenticationService.entities.UserServiceRequest;
import majorProject.one.AuthenticationService.manager.UserService;
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
