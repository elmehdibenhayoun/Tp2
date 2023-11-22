package ma.mundiapolis.tp2.repositories;


import ma.mundiapolis.tp2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUserName(String userName);
}
