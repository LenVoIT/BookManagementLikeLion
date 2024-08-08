package BookManagement.Spring.Service;

import BookManagement.Spring.Entity.UserEntity;

public interface UserService extends BaseService<UserEntity> {
    UserEntity login(String username, String password);

}
