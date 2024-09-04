package org.example.hybrid_approach.services;

import org.example.hybrid_approach.entities.Customer;
import org.example.hybrid_approach.entities.Order;
import org.example.hybrid_approach.entities.OrderItem;
import org.example.hybrid_approach.entities.Product;
import org.example.hybrid_approach.repository.CustomerRepository;
import org.example.hybrid_approach.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductService productService;
    private final PaymentGatewayStub paymentGatewayStub;

    public OrderService(ProductService productService, PaymentGatewayStub paymentGatewayStub,
                        OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.productService = productService;
        this.paymentGatewayStub = paymentGatewayStub;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order createOrder(Customer customer, Map<Long, Integer> cartItems) {
        Customer savedCustomer = customerRepository.save(customer);
        Order order = new Order();
        order.setCustomer(savedCustomer);
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> orderItems = cartItems.entrySet().stream()
                .map(entry -> {
                    Product product = productService.getProductById(entry.getKey());
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(product);
                    orderItem.setQuantity(entry.getValue());
                    return orderItem;
                }).collect(Collectors.toList());

        order.setItems(orderItems);
        order = orderRepository.save(order);

        boolean paymentSuccess = paymentGatewayStub.processPayment(order);
        if (!paymentSuccess) {
            throw new RuntimeException("Payment processing failed");
        }

        return order;
    }
}

