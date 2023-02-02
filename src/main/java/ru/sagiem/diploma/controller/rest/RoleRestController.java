package ru.sagiem.diploma.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sagiem.diploma.model.Role;
import ru.sagiem.diploma.service.interf.CRUDService;
import ru.sagiem.diploma.service.interf.RoleService;

@RestController
@RequestMapping(RoleRestController.ROLE_REST_URL)
public class RoleRestController extends CRUDRestController<Role, Long>{
    public static final String ROLE_REST_URL = "role";

    @Autowired
    private RoleService roleService;

    @Override
    CRUDService<Role, Long> getService() {
        return roleService;
    }
}
