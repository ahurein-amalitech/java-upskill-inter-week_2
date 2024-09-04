package org.example.hybrid_approach.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartService {
    private Map<Long, Integer> cartItems = new HashMap<>();

    public void addProductToCart(Long productId, int quantity) {
        cartItems.put(productId, cartItems.getOrDefault(productId, 0) + quantity);
    }

    public Map<Long, Integer> getCartItems() {
        return cartItems;
    }
}
