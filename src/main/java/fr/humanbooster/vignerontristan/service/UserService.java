package fr.humanbooster.vignerontristan.service;

import fr.humanbooster.vignerontristan.dto.MapDto;
import fr.humanbooster.vignerontristan.dto.UserRegisterDto;
import fr.humanbooster.vignerontristan.entity.Map;
import fr.humanbooster.vignerontristan.repository.UserRepository;
import fr.humanbooster.vignerontristan.entity.User;
import fr.humanbooster.vignerontristan.service.interfaces.ServiceIdInterface;
import fr.humanbooster.vignerontristan.service.interfaces.ServiceInterfaceBase;
import fr.humanbooster.vignerontristan.service.utils.FileUploaderService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class UserService implements
        ServiceInterfaceBase<User, UserRegisterDto>,
        ServiceIdInterface<User, String>,
        UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User create(UserRegisterDto userDto) {
        return userRepository.saveAndFlush(objectRegisterFromDto(new User(), userDto));
    }
    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    private User objectRegisterFromDto(User user, UserRegisterDto userDto) {
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setAvatar(userDto.getAvatar());
        user.setBirthedAt(userDto.getBirthedAt());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Fire in the hole"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getAuthorities()

        );

    }


    public Boolean uploadImage(MultipartFile file, Principal principal) {
        if (principal != null) {
            User user = findOneByEmail(principal.getName());
            FileUploaderService fileUploaderService = new FileUploaderService("uploads/user");
            String filename = fileUploaderService.save(file);
            if (filename != null) {
                user.setAvatar(filename);
                userRepository.saveAndFlush(user);
                return true;
            }
        }
        return false;
    }

    public User findOneByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
    }
}
