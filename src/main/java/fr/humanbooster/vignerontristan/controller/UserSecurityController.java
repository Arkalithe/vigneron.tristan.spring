package fr.humanbooster.vignerontristan.controller;

import fr.humanbooster.vignerontristan.custom_response.JwtResponse;
import fr.humanbooster.vignerontristan.dto.UserLoginDto;
import fr.humanbooster.vignerontristan.dto.UserRegisterDto;
import fr.humanbooster.vignerontristan.entity.User;
import fr.humanbooster.vignerontristan.security.JwtAuthenticatorService;
import fr.humanbooster.vignerontristan.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserSecurityController {

    private final UserService userService;
    private final JwtAuthenticatorService jwtAuthenticatorService;

//    @PostMapping("/register")
//    public User register(@Valid @RequestBody UserRegisterDto user) {
//        return userService.create(user);
//    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserLoginDto user) {
        return jwtAuthenticatorService.authenticate(user);
    }
}
