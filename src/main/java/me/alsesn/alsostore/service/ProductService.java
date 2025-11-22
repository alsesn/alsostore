package me.alsesn.alsostore.service;

import lombok.RequiredArgsConstructor;
import me.alsesn.alsostore.entity.Product;
import me.alsesn.alsostore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(Long categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }
}