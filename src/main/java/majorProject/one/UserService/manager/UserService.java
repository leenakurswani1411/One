package majorProject.one.UserService.manager;

import majorProject.one.UserService.entities.UserResponse;
import majorProject.one.UserService.entities.UserServiceRequest;

public interface UserService {

    void createUser(UserServiceRequest userServiceRRequest);

    UserResponse get(String username);

    //UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
}
