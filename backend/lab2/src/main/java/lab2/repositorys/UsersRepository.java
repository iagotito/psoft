package lab2.repositorys;

import lab2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UsersRepository<T, ID extends Serializable> extends JpaRepository<User, String> {

}
