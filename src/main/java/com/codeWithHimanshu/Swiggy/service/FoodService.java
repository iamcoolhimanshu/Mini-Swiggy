package com.codeWithHimanshu.Swiggy.service;

import com.codeWithHimanshu.Swiggy.entity.FoodItem;

import java.util.List;

public interface FoodService {

    FoodItem saveFood(FoodItem foodItem);

    FoodItem updateFood(Long id, FoodItem foodItem);

    void deleteFood(Long id);

    FoodItem getFoodById(Long id);

    List<FoodItem> getAllFoods();
}
