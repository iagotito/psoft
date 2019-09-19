package lab2.controllers;

import lab2.entities.User;
import lab2.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private UsersService usersService;

    public UsersController (UsersService usersService) {
        super();
        this.usersService = usersService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> postUser (@RequestBody User user) {
        return new ResponseEntity<>(usersService.postUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers () {
        return new ResponseEntity<>(usersService.getUsers(), HttpStatus.OK);
    }

}
