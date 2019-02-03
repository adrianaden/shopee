package org.shopee.adrianaden.challenge.api.service.impl;

import org.shopee.adrianaden.challenge.api.entity.Product;
import org.shopee.adrianaden.challenge.api.repository.ProductRepository;
import org.shopee.adrianaden.challenge.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
