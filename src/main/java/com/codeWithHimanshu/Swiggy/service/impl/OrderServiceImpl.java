package com.codeWithHimanshu.Swiggy.service.impl;

import com.codeWithHimanshu.Swiggy.entity.CartItem;
import com.codeWithHimanshu.Swiggy.entity.Order;
import com.codeWithHimanshu.Swiggy.repository.CartItemRepository;
import com.codeWithHimanshu.Swiggy.repository.OrderRepository;
import com.codeWithHimanshu.Swiggy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CartItemRepository cartRepo;
    private final OrderRepository orderRepo;

    @Override
    public Order placeOrder(Long userId) {
        List<CartItem> items = cartRepo.findByUserId(userId);

        if (items.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        double total = items.size() * 100; // dummy calculation

        String itemList = "";
        for (CartItem i : items) {
            itemList += "FoodID:" + i.getFoodId() + " Qty:" + i.getQuantity() + ", ";
        }

        Order order = Order.builder().userId(userId).items(itemList).totalAmount(total).status("PENDING").build();

        cartRepo.deleteAll(items);

        return orderRepo.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));

        order.setStatus(status);
        return orderRepo.save(order);
    }
}
