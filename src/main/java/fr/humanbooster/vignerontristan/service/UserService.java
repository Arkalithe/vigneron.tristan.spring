package fr.humanbooster.vignerontristan.service;

import fr.humanbooster.vignerontristan.dto.UserRegisterDto;
import fr.humanbooster.vignerontristan.repository.UserRepository;
import fr.humanbooster.vignerontristan.entity.User;
import fr.humanbooster.vignerontristan.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    public User create(UserRegisterDto userDto) {
        return userRepository.saveAndFlush(objectRegisterFromDto(new User(), userDto));
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public List<User> list() {
        return userRepository.findAll();
    }

    private User objectRegisterFromDto(User user, UserRegisterDto userDto) {

        //Faire les xxx.set(xxx.get());
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
}
