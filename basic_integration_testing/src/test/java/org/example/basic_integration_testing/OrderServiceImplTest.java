package org.example.basic_integration_testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveOrder() {
        Order order = new Order();
        order.setName("OrderOne");
        boolean isSaved = orderService.saveOrder(order);
        assertEquals(true, isSaved);
    }
}