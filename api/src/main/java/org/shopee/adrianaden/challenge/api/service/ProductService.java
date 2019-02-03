package org.shopee.adrianaden.challenge.api.service;

import org.shopee.adrianaden.challenge.api.entity.Product;

public interface ProductService {
    /**
     * insert new product
     *
     * @param product product to be insert
     * @return inserted product
     */
    Product create(Product product);
}
