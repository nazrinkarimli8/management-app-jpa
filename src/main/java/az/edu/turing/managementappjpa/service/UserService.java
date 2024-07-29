package az.edu.turing.managementappjpa.service;

import az.edu.turing.managementappjpa.domain.entity.UserEntity;
import az.edu.turing.managementappjpa.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(UserDto userDto);

    List<UserEntity> getAll();

    Optional<UserEntity> getById(Long id);

    void deleteAll();

    void deleteById(Long id);

    UserEntity update(Long id, UserEntity userEntity);

    UserEntity updateAge(Long id, UserEntity userEntity);

    long countUsers();
}
