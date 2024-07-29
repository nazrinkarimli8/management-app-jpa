package az.edu.turing.managementappjpa.domain.repository;

import az.edu.turing.managementappjpa.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
