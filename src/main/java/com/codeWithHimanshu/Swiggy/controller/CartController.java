package com.codeWithHimanshu.Swiggy.controller;

import com.codeWithHimanshu.Swiggy.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{userId}")
    public String viewCart(@PathVariable Long userId, Model model) {
        model.addAttribute("cartItems", cartService.getUserCart(userId));
        model.addAttribute("userId", userId);
        return "cart";
    }

    @GetMapping("/cart/{userId}/add/{productId}")
    public String addToCart(@PathVariable Long userId,
                            @PathVariable Long productId) {
        cartService.addToCart(userId, productId);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}/{userId}")
    public String remove(@PathVariable Long id, @PathVariable Long userId) {
        cartService.removeItem(id);
        return "redirect:/cart/" + userId;
    }

    @GetMapping("/clear/{userId}")
    public String clear(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return "redirect:/cart/" + userId;
    }
}
