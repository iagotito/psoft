package lab2.controllers;

import lab2.entities.User;
import lab2.services.JwtService;
import lab2.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;

@RestController
public class UsersController {

    private UsersService usersService;
    private JwtService jwtService;

    public UsersController (UsersService usersService, JwtService jwtService) {
        super();
        this.usersService = usersService;
        this.jwtService = jwtService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> postUser (@RequestBody User user) {
        return new ResponseEntity<>(usersService.postUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers () {
        return new ResponseEntity<>(usersService.getUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/auth/users")
    public ResponseEntity<User> deleteUser (@RequestHeader("Authorization") String header) throws ServletException {
        if (!jwtService.userExists(header))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usersService.deleteUser(jwtService.getTokenSubject(header)).get(), HttpStatus.OK);
        // TODO: return appropiate Http codes for erros
    }



}
