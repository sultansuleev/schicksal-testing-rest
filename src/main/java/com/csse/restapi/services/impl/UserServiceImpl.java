package com.csse.restapi.services.impl;

import com.csse.restapi.entities.Roles;
import com.csse.restapi.entities.Users;
import com.csse.restapi.repositories.RolesRepository;
import com.csse.restapi.repositories.UsersRepository;
import com.csse.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(s);
        if(user!=null){
            return user;
        }else{
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
    }

    @Override
    public void deleteUser(Users user) {
        userRepository.delete(user);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public String getPasswordByEmail(String email) {
        return userRepository.findByEmail(email).getPassword();
    }

    @Override
    public Users getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Roles getRole(Long id) {
        Optional<Roles> opt = rolesRepository.findById(id);
        return opt.isPresent()?opt.get():null;
    }

    @Override
    public Users AdmSaveUserInfo(Users item) {
        return userRepository.save(item);
    }
}