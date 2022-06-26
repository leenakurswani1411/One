package majorProject.one.UserService.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserServiceRequest {
    private String username;
    private String password;
    private String email;
}
