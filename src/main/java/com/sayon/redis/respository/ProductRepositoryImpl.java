package com.sayon.redis.respository;

import com.sayon.redis.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@AllArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    public static final String HASH_NAME = "Product";

    @Autowired
    private final RedisTemplate redisTemplate;

    public Product save(Product product) {
        redisTemplate.opsForHash().put(HASH_NAME, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return redisTemplate.opsForHash().values(HASH_NAME);
    }

    public Product findProductById (int id) {
        return (Product) redisTemplate.opsForHash().get(HASH_NAME, id);
    }

    public void deleteProduct(int id) {
        redisTemplate.opsForHash().delete(HASH_NAME, id);
    }
}
