package com.codeWithHimanshu.Swiggy.service;

import com.codeWithHimanshu.Swiggy.entity.User;

public interface UserService {
    User register(User user);

    User findByEmail(String email);
}
