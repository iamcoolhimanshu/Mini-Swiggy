package com.codeWithHimanshu.Swiggy.repository;

import com.codeWithHimanshu.Swiggy.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);
}
