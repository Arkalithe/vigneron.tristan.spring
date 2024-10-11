package fr.humanbooster.vignerontristan.controller;

import fr.humanbooster.vignerontristan.dto.UserDto;
import fr.humanbooster.vignerontristan.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

}
