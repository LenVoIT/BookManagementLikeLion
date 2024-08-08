package BookManagement.Spring.Model;

import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    private String username;
    private String password;

}
