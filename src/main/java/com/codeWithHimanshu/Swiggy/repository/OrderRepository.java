package com.codeWithHimanshu.Swiggy.repository;

import com.codeWithHimanshu.Swiggy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
