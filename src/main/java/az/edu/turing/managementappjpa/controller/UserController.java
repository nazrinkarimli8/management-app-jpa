package az.edu.turing.managementappjpa.controller;

import az.edu.turing.managementappjpa.domain.entity.UserEntity;
import az.edu.turing.managementappjpa.model.UserDto;
import az.edu.turing.managementappjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        logger.info("Create user request received: {}", userDto);
        userService.save(userDto);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        logger.info("Get all users request received");
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id) {
        logger.info("Get user by id request received: {}", id);
        return userService.getById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllUsers() {
        logger.info("Delete all users request received");
        userService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        logger.info("Delete user by id request received: {}", id);
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUserById(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        logger.info("Update user by id request received: {}", id);
        return userService.update(id, userEntity);
    }

    @PatchMapping("/age/{id}")
    public UserEntity updateUserAge(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        logger.info("Update user age by id request received: {}", id);
        return userService.updateAge(id, userEntity);
    }

    @GetMapping("/count")
    public long getCountUsers() {
        logger.info("Get count of users request received");
        return userService.countUsers();
    }
}

//  facade and strategy pattern
//   docs.spring.io/spring-data/jpa/reference/repositories      (projections qeder)
// vavr