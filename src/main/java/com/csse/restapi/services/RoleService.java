package com.csse.restapi.services;

import com.csse.restapi.entities.Roles;

public interface RoleService {

    Roles getRoleByName(String role);

}