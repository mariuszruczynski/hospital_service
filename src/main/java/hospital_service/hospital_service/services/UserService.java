package hospital_service.hospital_service.services;

import hospital_service.hospital_service.exception.HospitalException;
import hospital_service.hospital_service.model.UserDto;
import hospital_service.hospital_service.model.UserEntity;
import hospital_service.hospital_service.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);

        return toUserDetails(userEntity);
    }

    public void createUser(UserDto userDto) {

        userRepository.save(convertToUser(userDto));
    }

    private UserEntity convertToUser(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        validate(userDto);
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setEmail(userDto.getEmail());
        return userEntity;
    }

    private void validate(UserDto userDto) {

        List<String> errors = new ArrayList<>();
        checkIsUsernameNotNull(userDto.getUsername(), errors);
        checkIsPasswordNotNull(userDto.getPassword(), errors);
        checkIsEmailNotNull(userDto.getEmail(), errors);
        if(!errors.isEmpty()){
            throw new HospitalException(errors);
        }

        checkIsUsernameExist(userDto.getUsername(),errors);

    }

    private void checkIsUsernameExist(String username, List<String> errors) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(!isNull(userEntity)){
            errors.add("This user exist");
            throw new HospitalException(errors);
        }

    }

    private void checkIsEmailNotNull(String email, List<String> errors) {
        if (email.isEmpty()) {
            errors.add("Email can't be null");
        }
    }

    private void checkIsPasswordNotNull(String password, List<String> errors) {
        if (password.isEmpty()) {
            errors.add("Password can't be null");
        }
    }

    private void checkIsUsernameNotNull(String username, List<String> errors) {
        if (username.isEmpty()) {
            errors.add("Username can't be null");
        }
    }

    private UserDetails toUserDetails(UserEntity userEntity) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(Collections.EMPTY_LIST)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .build();
    }
}
