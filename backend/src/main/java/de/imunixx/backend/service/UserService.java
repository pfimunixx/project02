package de.imunixx.backend.service;

import de.imunixx.api.entity.*;
import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.ProfileDTO;
import de.imunixx.api.model.UserCreateDTO;
import de.imunixx.api.model.UserDTO;
import de.imunixx.api.model.UserLoginDTO;
import de.imunixx.backend.exception.UserNotFoundException;
import de.imunixx.backend.repository.UserActivatedRepository;
import de.imunixx.backend.repository.UserDataRepository;
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
    private final UserActivatedRepository userActivatedRepository;
    private final UserDataRepository userDataRepository;
    private final BackEndMapper mapper;

    public UserDTO addUser(UserCreateDTO userCreateDTO) {
        User user = new User(null, userCreateDTO.getUserName(), userCreateDTO.getPassword(),
                userCreateDTO.getUserCode(),null, null, null);
        UserData userData = new UserData(null, userCreateDTO.getFirstName(), userCreateDTO.getSurName(), user,
                null, null);
        UserActivated userActivated = new UserActivated(null, false, user);

        userActivated = userActivatedRepository.save(userActivated);
        userData = userDataRepository.save(userData);
        user.setUserActivated(userActivated);
        user.setUserData(userData);

        user = userRepository.save(user);
        return mapper.toDto(user);
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
        userDataRepository.deleteUserDataByUserId(id);
        userActivatedRepository.deleteUserActivatedByUserId(id);
        if(userRepository.existsById(id)) {
            throw new UserNotFoundException("User by id" + id + " could not be deleted");
        }
    }

    public List<UserDTO> findAllUsers() {
        return mapper.toUserDtoList(userRepository.findAll());
    }

    public List<ProfileDTO> findProfilesListById(Long id) {
        return mapper.toProfileDtoList(userRepository.findProfilesListById(id));
    }

    public UserDTO login(UserLoginDTO userLoginDTO) {
        return mapper.toDto(userRepository.findUserByUserNameAndPassword(userLoginDTO.getUserName(), userLoginDTO.getPassword())
                .orElseThrow(()-> new UserNotFoundException("User by userName " + userLoginDTO.getUserName() +
                        "not found with that password")));
    }

}
