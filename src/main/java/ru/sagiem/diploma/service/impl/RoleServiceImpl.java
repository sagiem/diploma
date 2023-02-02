package ru.sagiem.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.sagiem.diploma.model.Role;
import ru.sagiem.diploma.repository.RoleRepository;
import ru.sagiem.diploma.service.interf.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractCRUDService<Role, Long> implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Override
    CrudRepository<Role, Long> getRepository(){
        return roleRepository;
    }
}
