package az.edu.turing.managementappjpa.service.impl;

import az.edu.turing.managementappjpa.domain.entity.UserEntity;
import az.edu.turing.managementappjpa.domain.repository.UserRepository;
import az.edu.turing.managementappjpa.exception.UserNotFoundException;
import az.edu.turing.managementappjpa.model.UserDto;
import az.edu.turing.managementappjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .username(userDto.getUsername())
                .age(userDto.getAge())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .profilePhoto(userDto.getProfilePhoto())
                .build();
        userRepository.save(userEntity);
        logger.info("User saved: {}", userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> users = userRepository.findAll();
        logger.info("Fetched all users");
        return users;
    }

    @Override
    public Optional<UserEntity> getById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            logger.info("User found with id: {}", id);
        } else {
            logger.warn("User not found with id: {}", id);
            throw new UserNotFoundException("User not found with id: " + id);
        }
        return user;
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
        logger.info("All users deleted");
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
        logger.info("User deleted with id: {}", id);
    }

    @Override
    public UserEntity update(Long id, UserEntity userEntity) {
        Optional<UserEntity> foundedUser = userRepository.findById(id);

        if (foundedUser.isPresent()) {
            UserEntity updatedUser = foundedUser.get();
            updatedUser.setUsername(userEntity.getUsername());
            updatedUser.setAge(userEntity.getAge());
            updatedUser.setCreated(LocalDateTime.now());
            updatedUser.setUpdated(LocalDateTime.now());
            updatedUser.setProfilePhoto(userEntity.getProfilePhoto());
            userRepository.save(updatedUser);
            logger.info("User updated with id: {}", id);
            return updatedUser;
        } else {
            logger.warn("User not found with id: {}", id);
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public UserEntity updateAge(Long id, UserEntity userEntity) {
        Optional<UserEntity> foundedUser = userRepository.findById(id);
        if (foundedUser.isPresent()) {
            UserEntity updatedUser = foundedUser.get();
            updatedUser.setAge(userEntity.getAge());
            userRepository.save(updatedUser);
            logger.info("User age updated with id: {}", id);
            return updatedUser;
        } else {
            logger.warn("User not found with id: {}", id);
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public long countUsers() {
        long count = userRepository.count();
        logger.info("Total number of users: {}", count);
        return count;
    }
}
