package ru.sagiem.diploma.service.impl;

import org.springframework.stereotype.Service;
import ru.sagiem.diploma.model.Task;
import ru.sagiem.diploma.service.interf.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public void create(Task entity) {

    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task update(Task entity) {
        return null;
    }

    @Override
    public void delete(Task entity) {

    }
}
