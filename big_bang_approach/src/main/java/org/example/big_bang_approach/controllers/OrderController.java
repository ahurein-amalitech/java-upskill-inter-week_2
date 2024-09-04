package org.example.big_bang_approach.controllers;

import org.example.big_bang_approach.entities.Order;
import org.example.big_bang_approach.entities.Product;
import org.example.big_bang_approach.repository.OrderRepository;
import org.example.big_bang_approach.repository.ProductRepository;
import org.example.big_bang_approach.service.OrderService;
import org.example.big_bang_approach.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        List<Product> products = orders.stream().map(Order::getProduct).toList();
        model.addAttribute("products", products);
        return "orders";
    }

    @PostMapping("/order/{id}")
    public String addOrder(@PathVariable("id") String id) {
        int productId = Integer.parseInt(id);
        Product product = productService.findProduct(productId);
        if (product != null) {
            Order orderExist = orderService.findOrderByProductId(product.getId());
            if (orderExist != null)  return  "redirect:/orders";
            Order order = new Order();
            order.setProduct(product);
            orderService.save(order);

            return "order-successful";
        }
        return "redirect:/products";
    }
}
