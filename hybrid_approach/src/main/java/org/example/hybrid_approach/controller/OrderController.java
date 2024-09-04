package org.example.hybrid_approach.controller;

import org.example.hybrid_approach.entities.Customer;
import org.example.hybrid_approach.entities.Order;
import org.example.hybrid_approach.services.OrderService;
import org.example.hybrid_approach.services.ShoppingCartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService, ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Customer customer) {
        return orderService.createOrder(customer, shoppingCartService.getCartItems());
    }
}
