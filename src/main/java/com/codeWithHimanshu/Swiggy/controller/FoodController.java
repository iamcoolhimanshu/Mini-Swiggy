package com.codeWithHimanshu.Swiggy.controller;

import com.codeWithHimanshu.Swiggy.entity.FoodItem;
import com.codeWithHimanshu.Swiggy.service.FileStorageService;
import com.codeWithHimanshu.Swiggy.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;
    private final FileStorageService fileStorageService;

    @GetMapping("/list")
    public String listFoods(Model model) {
        model.addAttribute("foods", foodService.getAllFoods());
        return "food-list";
    }

    @GetMapping("/add")
    public String addFoodForm(Model model) {
        model.addAttribute("food", new FoodItem());
        return "food-form";
    }

    @PostMapping("/add")
    public String saveFood(@ModelAttribute FoodItem foodItem,
                           @RequestParam("image") MultipartFile imageFile) {

        if (!imageFile.isEmpty()) {
            String imagePath = fileStorageService.saveFile(imageFile);
            foodItem.setImageUrl(imagePath);
        }

        foodService.saveFood(foodItem);
        return "redirect:/food/list";
    }

    @GetMapping("/edit/{id}")
    public String editFood(@PathVariable Long id, Model model) {
        model.addAttribute("food", foodService.getFoodById(id));
        return "food-form";
    }

    @PostMapping("/update/{id}")
    public String updateFood(@PathVariable Long id,
                             @ModelAttribute FoodItem foodItem,
                             @RequestParam("image") MultipartFile imageFile) {

        if (!imageFile.isEmpty()) {
            String imagePath = fileStorageService.saveFile(imageFile);
            foodItem.setImageUrl(imagePath);
        }

        foodService.updateFood(id, foodItem);
        return "redirect:/food/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return "redirect:/food/list";
    }
}
