package ru.sagiem.diploma.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sagiem.diploma.model.Task;
import ru.sagiem.diploma.service.interf.CRUDService;
import ru.sagiem.diploma.service.interf.TaskService;

@RestController
@RequestMapping(TaskRestController.TASK_REST_URL)
public class TaskRestController extends CRUDRestController<Task, Long> {
    public static final String TASK_REST_URL = "task";

    @Autowired
    private TaskService taskService;

    @Override
    CRUDService<Task, Long> getService() {
        return taskService;
    }
}
