package BookManagement.Spring.Controller;

import BookManagement.Spring.Entity.UserEntity;
import BookManagement.Spring.Model.UserDTO;
import BookManagement.Spring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    private UserEntity createUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = UserEntity
                .builder()
                .username(userDTO.getUsername())
                .password(Base64.getEncoder().encodeToString(userDTO.getPassword().getBytes()))
                .build();

        return userService.create(userEntity);
    }

    @PutMapping("/update/{id}")
    private UserEntity updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        UserEntity userEntity = userService.findById(id);
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(Base64.getEncoder().encodeToString(userDTO.getPassword().getBytes()));
        return userService.save(userEntity);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable int id) {
        userService.remove(id);

    }

    @PostMapping
    private UserEntity login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO.getUsername(), userDTO.getPassword());
    }
}
