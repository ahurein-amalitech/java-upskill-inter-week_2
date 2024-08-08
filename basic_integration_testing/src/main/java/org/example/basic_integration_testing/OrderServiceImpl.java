package org.example.basic_integration_testing;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean saveOrder(Order order){
        orderRepository.save(order);
        return true;
    }
}
