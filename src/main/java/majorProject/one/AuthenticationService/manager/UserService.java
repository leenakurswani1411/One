package majorProject.one.AuthenticationService.manager;

import majorProject.one.AuthenticationService.entities.UserResponse;
import majorProject.one.AuthenticationService.entities.UserServiceRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

public interface UserService {

    void createUser(UserServiceRequest userServiceRRequest);

    UserResponse get(String username);

    //UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
}
