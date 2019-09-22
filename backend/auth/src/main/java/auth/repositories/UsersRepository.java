package auth.repositories;

import auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UsersRepository<T, ID extends Serializable> extends JpaRepository<User, String> {
}
