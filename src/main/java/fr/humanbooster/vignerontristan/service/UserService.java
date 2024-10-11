package fr.humanbooster.vignerontristan.service;

import fr.humanbooster.vignerontristan.repository.UserRepository;
import fr.humanbooster.vignerontristan.entity.User;
import fr.humanbooster.vignerontristan.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User create(UserDto userDto) {
        return userRepository.saveAndFlush(objectFromDto(new User(), userDto));
    }


    public User update(UserDto userDto, String id) {
        User user = objectFromDto(findById(id), userDto);
        user.setId(id);
        userRepository.flush();
        return user;
    }


    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public List<User> list() {
        return userRepository.findAll();
    }

    private User objectFromDto(User user, UserDto userDto) {

        //Faire les xxx.set(xxx.get());
        return user;
    }
}
