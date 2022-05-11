package com.sayon.redis.controller;

import com.sayon.redis.entity.Product;
import com.sayon.redis.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        return repository.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        repository.deleteProduct(id);
    }

}
