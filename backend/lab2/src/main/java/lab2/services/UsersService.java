package lab2.services;

import lab2.entities.User;
import lab2.repositorys.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private UsersRepository <User, String> usersRepository;

    public UsersService (UsersRepository<User, String> usersRepository) {
        super ();
        this.usersRepository = usersRepository;
    }

    public User postUser (User user) {
        return usersRepository.save(user);
    }

    public List<User> getUsers() {
        return usersRepository.findAll();
    }
}
