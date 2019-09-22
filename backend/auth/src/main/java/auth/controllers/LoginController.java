package auth.controllers;

import auth.entities.User;
import auth.services.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final String TOKEN_KEY = "login do batman";

    private UsersService usersService;

    public LoginController(UsersService usersService) {
        super();
        this.usersService = usersService;
    }

    @PostMapping("/login")
    public LoginResponse authenticate(@RequestBody User user) throws ServletException {

        // Retieve the user
        Optional<User> authUser = usersService.getUser(user.getEmail());

        // verifications
        if (authUser.isEmpty())
            throw new ServletException("User not found!");
        if (!authUser.get().getPassword().equals(user.getPassword()))
            throw new ServletException("Invalid password!");

        String token = generateToken(authUser.get().getEmail());

        return new LoginResponse(token);

    }

    public String generateToken(String email) {
        return Jwts.builder().setSubject(email)
                .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();
    }

    private class LoginResponse {
        public String token;

        public LoginResponse(String token) {
            this.token = token;
        }
    }

}
