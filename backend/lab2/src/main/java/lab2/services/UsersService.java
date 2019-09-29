package lab2.services;

import lab2.entities.User;
import lab2.repositorys.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUser (String email) {
        return usersRepository.findById(email);
    }

    public Optional<User> deleteUser (String email) {
        Optional<User> optUser = usersRepository.findById(email);
        if (optUser.isPresent())
            usersRepository.deleteById(email);
        return optUser;
    }


}
