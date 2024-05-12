package com.scm.services;

import com.scm.entities.User;
import com.scm.helper.RegisterForm;

public interface UserService {

    User saveUser(RegisterForm registerForm);

}
