package auth.controllers;

import auth.entities.User;
import auth.services.JwtService;
import auth.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    private UsersService usersService;
    private JwtService jwtService;

    public UsersController(UsersService usersService, JwtService jwtService) {
        super();
        this.usersService = usersService;
        this.jwtService = jwtService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> postUser (@RequestBody User user) {
        try {
            return new ResponseEntity<>(usersService.postUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<User> getUser (@PathVariable String email) {
        Optional<User> user = usersService.getUser(email);
        if (user.isPresent())
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers () {
        return new ResponseEntity<>(usersService.getUsers(), HttpStatus.OK);
    }

    @DeleteMapping("auth/users/{email}")
    public ResponseEntity<User> removeUsuario(@PathVariable String email, @RequestHeader("Authorization") String header) throws ServletException {
        if(!jwtService.userExistis(email))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        try {
            if(jwtService.userHavePermission(header, email))
                return new ResponseEntity<>(usersService.deleteUser(email), HttpStatus.OK);
        } catch (ServletException e) {
            //user esta com token invalido ou vencido
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        //user nao tem permissao
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
