package lab2.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import lab2.Filters.TokenFilter;
import lab2.entities.User;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.Optional;

@Service
public class JwtService {
    private UsersService usersService;

    public JwtService(UsersService usersService) {
        super();
        this.usersService = usersService;
    }

    public boolean userExists(String authorizationHeader) throws ServletException {
        String subject = getTokenSubject(authorizationHeader);

        return usersService.getUser(subject).isPresent();
    }

    public boolean userHavePermission(String authorizationHeader, String email) throws ServletException {
        String subject = getTokenSubject(authorizationHeader);

        Optional<User> optUser = usersService.getUser(subject);
        return optUser.isPresent() && optUser.get().getEmail().equals(email);
    }

    public String getTokenSubject(String authorizationHeader) throws ServletException {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ServletException("Missing or badly formatted token!");
        }

        // Extraindo apenas o token do cabecalho.
        String token = authorizationHeader.substring(TokenFilter.TOKEN_INDEX);

        String subject;
        try {
            subject = Jwts.parser().setSigningKey("login do batman").parseClaimsJws(token).getBody().getSubject();
        } catch (SignatureException e) {
            throw new ServletException("Invalid or expired token!");
        }
        return subject;
    }

}