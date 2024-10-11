package fr.humanbooster.vignerontristan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.vignerontristan.entity.Map;
import fr.humanbooster.vignerontristan.entity.User;
import fr.humanbooster.vignerontristan.jsonviews.MapJsonview;
import fr.humanbooster.vignerontristan.jsonviews.UserJsonview;
import fr.humanbooster.vignerontristan.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    @JsonView( UserJsonview.UserShowView.class)
    public User getGameById( Principal principal) {
        return userService.findOneByEmail(principal.getName());
    }

    @PostMapping("/upload")
    public ResponseEntity<Boolean> uploadPhoto(
            @RequestParam("userAvatar") MultipartFile file,
            Principal principal
    ) {
        return new ResponseEntity<>(userService.uploadImage(file, principal), HttpStatus.ACCEPTED);
    }

}
