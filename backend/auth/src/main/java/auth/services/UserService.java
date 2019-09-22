package auth.services;

import auth.entities.User;
import auth.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository<User, String> userRepository;

    public UserService (UserRepository<User, String> userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public User postUser (User user) throws Exception {
        Optional<User> userOptional = getUser(user.getEmail());
        if (userOptional.isPresent())
            throw new Exception("User already exists.");
        return userRepository.save(user);
    }

    public Optional<User> getUser (String email) {
        return userRepository.findById(email);
    }

}
