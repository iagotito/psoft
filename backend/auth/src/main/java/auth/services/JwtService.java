package auth.services;

import auth.entities.User;
import auth.filters.TokenFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.Optional;

@Service
public class JwtService {

    private UsersService usersService;

    public JwtService (UsersService usersService) {
        super();
        this.usersService = usersService;
    }

    public boolean userExistis (String authoriationHeader) throws ServletException {
        String subject = getTokenSubject(authoriationHeader);

        return usersService.getUser(subject).isPresent();
    }

    public boolean userHavePermission(String authorizationHeader, String email) throws ServletException {
        String subject = getTokenSubject(authorizationHeader);

        Optional<User> optionalUser = usersService.getUser(subject);
        return optionalUser.isPresent() && optionalUser.get().getEmail().equals(email);
    }

    public String getTokenSubject (String authorizationHeader) throws ServletException {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ServletException("missing or badly formatted token!");
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
