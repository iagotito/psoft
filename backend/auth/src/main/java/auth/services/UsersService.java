package auth.services;

import auth.entities.User;
import auth.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private UsersRepository<User, String> usersRepository;

    public UsersService(UsersRepository<User, String> usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    public User postUser (User user) throws Exception {
        Optional<User> userOptional = getUser(user.getEmail());
        if (userOptional.isPresent())
            throw new Exception("User already exists.");
        return usersRepository.save(user);
    }

    public Optional<User> getUser (String email) {
        return usersRepository.findById(email);
    }

    public List<User> getUsers () {
        return usersRepository.findAll();
    }

    public User deleteUser(String email) {
        User user = usersRepository.findById(email).get();
        usersRepository.deleteById(email);
        return user;
    }
}
