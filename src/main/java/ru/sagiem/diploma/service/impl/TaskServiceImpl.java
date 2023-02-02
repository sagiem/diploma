package ru.sagiem.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.sagiem.diploma.model.Task;
import ru.sagiem.diploma.repository.TaskRepository;
import ru.sagiem.diploma.service.interf.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractCRUDService<Task, Long> implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    CrudRepository<Task, Long> getRepository() {
        return taskRepository;
    }
}
