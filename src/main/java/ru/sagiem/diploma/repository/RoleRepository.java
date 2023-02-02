package ru.sagiem.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sagiem.diploma.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
