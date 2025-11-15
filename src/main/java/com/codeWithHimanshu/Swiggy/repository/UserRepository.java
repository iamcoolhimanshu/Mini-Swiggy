package com.codeWithHimanshu.Swiggy.repository;

import com.codeWithHimanshu.Swiggy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
