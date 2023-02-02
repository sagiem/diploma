package ru.sagiem.diploma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sagiem.diploma.model.Role;
import ru.sagiem.diploma.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
