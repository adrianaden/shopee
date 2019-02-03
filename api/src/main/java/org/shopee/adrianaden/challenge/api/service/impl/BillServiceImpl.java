package org.shopee.adrianaden.challenge.api.service.impl;

import org.shopee.adrianaden.challenge.api.common.type.product.ProductCategory;
import org.shopee.adrianaden.challenge.api.common.type.TypeProcessor;
import org.shopee.adrianaden.challenge.api.dto.BillSummary;
import org.shopee.adrianaden.challenge.api.dto.ProductSummary;
import org.shopee.adrianaden.challenge.api.entity.Product;
import org.shopee.adrianaden.challenge.api.service.BillService;
import org.shopee.adrianaden.challenge.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private ProductService productService;
    @Override
    public BillSummary findAll() {

        List<Product> products  =  productService.findAll();
        List<ProductSummary> productSummaries = new ArrayList<>();

        products.forEach(product -> {

            ProductCategory productCategory = TypeProcessor.findProductCategoryClass(product.getProductCategoryCode());

            ProductSummary productSummary = ProductSummary.builder()
                    .name(product.getName())
                    .categoryCode(product.getProductCategoryCode())
                    .price(product.getPrice())
                    .category(productCategory.getName())
                    .taxAmount(productCategory.calculateTax(product.getPrice()))
                    .isRefundable(productCategory.isRefundable())
                    .build();
            productSummaries.add(productSummary);
        });

        return BillSummary.builder()
                .productSummaries(productSummaries).build();
    }
}
