package com.gfg.session18jbdl30majorproject.UserService.manager;

import com.gfg.session18jbdl30majorproject.UserService.Entities.User;
import com.gfg.session18jbdl30majorproject.UserService.Entities.UserResponse;
import com.gfg.session18jbdl30majorproject.UserService.Entities.UserServiceRequest;
import com.gfg.session18jbdl30majorproject.UserService.MyPassWordEncoder;
import com.gfg.session18jbdl30majorproject.UserService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MyPassWordEncoder myPassWordEncoder;
    @Override
    public void create(UserServiceRequest userServiceRequest) {
        User user = User.builder()
                .password(myPassWordEncoder.getPasswordEncoder().encode(userServiceRequest.getPassword()))
                .username(userServiceRequest.getUsername())
                .email(userServiceRequest.getEmail())
                .build();

        userRepo.save(user);
    }

    @Override
    public UserResponse get(String username) {
       User user = userRepo.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException("username not found") );

        UserResponse userResponse = UserResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        return userResponse;
    }
}
