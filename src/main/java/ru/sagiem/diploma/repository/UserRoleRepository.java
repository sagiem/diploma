package ru.sagiem.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.model.UserRole;

import java.util.Optional;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    Iterable<UserRole> findAllByUserId(long userId);

}
