package org.example.hybrid_approach.services;

import org.example.hybrid_approach.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayStub {
    public boolean processPayment(Order order) {
        return true;
    }
}
