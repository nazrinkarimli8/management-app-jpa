package az.edu.turing.managementappjpa.controller;

import az.edu.turing.managementappjpa.domain.entity.UserEntity;
import az.edu.turing.managementappjpa.model.UserDto;
import az.edu.turing.managementappjpa.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;
    private final UserServiceImpl userServiceImpl;

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllUsers() {
        userService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUserById(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        return userService.update(id, userEntity);
    }

    @PatchMapping("/age/{id}")
    public UserEntity updateUserAge(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        return userServiceImpl.updateAge(id, userEntity);
    }

    @GetMapping("/count")
    public long getCountUsers() {
        return userService.countUsers();
    }
}
