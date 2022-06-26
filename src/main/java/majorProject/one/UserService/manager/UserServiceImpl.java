package majorProject.one.UserService.manager;

import majorProject.one.AuthenticationService.MyPasswordEncoder;
import majorProject.one.UserService.entities.User;
import majorProject.one.UserService.entities.UserResponse;
import majorProject.one.UserService.entities.UserServiceRequest;
import majorProject.one.UserService.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Override
    public void createUser(UserServiceRequest userServiceRRequest) {
        User user = User.builder()
                .password(userServiceRRequest.getPassword())
                .username(userServiceRRequest.getUsername())
                .email(userServiceRRequest.getEmail())
                .build();

        userRepo.save(user);
    }

    @Override
    public UserResponse get(String username) {
        User user = userRepo.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException("username not found") );

        UserResponse userResponse = UserResponse.builder()
                                    .password(user.getPassword())
                                    .email(user.getEmail())
                                    .username(user.getUsername())
                                    .build();
        return userResponse;
    }


}
