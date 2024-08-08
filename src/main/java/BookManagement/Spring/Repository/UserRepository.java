package BookManagement.Spring.Repository;

import BookManagement.Spring.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserByUsernameAndPassword(String username, String password);
}
