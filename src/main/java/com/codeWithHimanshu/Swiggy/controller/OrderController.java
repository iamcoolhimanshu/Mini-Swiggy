package com.codeWithHimanshu.Swiggy.controller;

import com.codeWithHimanshu.Swiggy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(@RequestParam Long userId) {
        orderService.placeOrder(userId);
        return "redirect:/order/list/" + userId;
    }

    @GetMapping("/list/{userId}")
    public String myOrders(@PathVariable Long userId, Model model) {
        model.addAttribute("orders", orderService.getOrdersByUserId(userId));
        return "order-list";
    }

    @GetMapping("/admin/all")
    public String allOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "admin-orders";
    }

    @PostMapping("/status/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        orderService.updateOrderStatus(id, status);
        return "redirect:/order/admin/all";
    }
}
