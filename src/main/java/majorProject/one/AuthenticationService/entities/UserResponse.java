package majorProject.one.AuthenticationService.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String username;
    private String password;
    private String email;
}
