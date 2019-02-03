package org.shopee.adrianaden.challenge.api.controller;

import org.shopee.adrianaden.challenge.api.entity.Product;
import org.shopee.adrianaden.challenge.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Product> create(@RequestBody @Validated Product product) {
        return ResponseEntity.ok(productService.create(product));
    }
}
