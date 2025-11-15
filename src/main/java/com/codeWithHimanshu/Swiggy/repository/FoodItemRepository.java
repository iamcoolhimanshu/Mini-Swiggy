package com.codeWithHimanshu.Swiggy.repository;

import com.codeWithHimanshu.Swiggy.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
