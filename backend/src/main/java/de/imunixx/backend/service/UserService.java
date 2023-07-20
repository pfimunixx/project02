package de.imunixx.backend.service;

import de.imunixx.api.entity.User;
import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.UserDTO;
import de.imunixx.backend.exception.UserNotFoundException;
import de.imunixx.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@Slf4j
@AllArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BackEndMapper mapper;

    public UserDTO addUser(UserDTO userDTO) {
        User entity = mapper.toEntity(userDTO);
        return mapper.toDto(userRepository.save(entity));
    }

    public UserDTO findUserById(Long id) {
        return mapper.toDto(userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id" + id + " not found")));
    }

    public UserDTO updateUser(UserDTO userDTO) {
        return mapper.toDto(userRepository.save(mapper.toEntity(userDTO)));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
        if(userRepository.existsById(id)) {
            throw new UserNotFoundException("User by id" + id + " could not be deleted");
        }
    }

    public List<UserDTO> findAllUsers() {
        return mapper.toUserDtoList(userRepository.findAll());
    }

}
