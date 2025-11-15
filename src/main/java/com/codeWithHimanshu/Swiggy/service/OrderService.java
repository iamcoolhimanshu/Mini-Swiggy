package com.codeWithHimanshu.Swiggy.service;

import com.codeWithHimanshu.Swiggy.entity.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(Long userId);

    List<Order> getOrdersByUserId(Long userId);

    List<Order> getAllOrders();

    Order updateOrderStatus(Long id, String status);
}
