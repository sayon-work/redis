package com.sayon.redis.respository;

import com.sayon.redis.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    List<Product> findAll();

    Product findProductById (int id);

    void deleteProduct(int id);
}
