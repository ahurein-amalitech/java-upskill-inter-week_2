package org.example.big_bang_approach.service;

import org.example.big_bang_approach.entities.Product;
import org.example.big_bang_approach.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product){
        return repository.save(product);
    }

    public Product findProduct(int productId){
        Optional<Product> productOptional = repository.findById(productId);
        if(productOptional.isEmpty()) throw new RuntimeException("Product not found");
        return productOptional.get();
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }
}
