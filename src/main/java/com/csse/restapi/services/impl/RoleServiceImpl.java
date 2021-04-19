package com.csse.restapi.services.impl;

import com.csse.restapi.entities.Roles;
import com.csse.restapi.repositories.RolesRepository;
import com.csse.restapi.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public Roles getRoleByName(String role) {
        return rolesRepository.findByRole(role);
    }
}