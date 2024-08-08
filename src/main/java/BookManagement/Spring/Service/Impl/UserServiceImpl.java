package BookManagement.Spring.Service.Impl;

import BookManagement.Spring.Entity.UserEntity;
import BookManagement.Spring.Model.UserDTO;
import BookManagement.Spring.Repository.UserRepository;
import BookManagement.Spring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity login(String username, String password) {
        return null;
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void remove(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(int id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }
}
