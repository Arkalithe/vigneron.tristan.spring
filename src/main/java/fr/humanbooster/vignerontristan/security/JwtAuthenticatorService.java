package fr.humanbooster.vignerontristan.security;


import fr.humanbooster.vignerontristan.custom_response.JwtResponse;
import fr.humanbooster.vignerontristan.dto.UserLoginDto;
import fr.humanbooster.vignerontristan.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtAuthenticatorService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public ResponseEntity<JwtResponse> authenticate(UserLoginDto dto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

            String token = jwtService.generateToken(dto.getEmail());
            return ResponseEntity.ok(new JwtResponse(token));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }
}
