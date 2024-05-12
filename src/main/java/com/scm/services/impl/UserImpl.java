package com.scm.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helper.RegisterForm;
import com.scm.repo.UserRepo;
import com.scm.services.UserService;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(RegisterForm registerForm) {
        User user = new User();
        user.setName(registerForm.getName());
        user.setAbout(registerForm.getAbout());
        user.setEmail(registerForm.getEmail());
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        user.setPhoneno(registerForm.getPhoneno());
        user.setUserid(UUID.randomUUID().toString());
        return this.userRepo.save(user);        
    }

}
