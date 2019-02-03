package org.shopee.adrianaden.challenge.api.common.builder;

import org.shopee.adrianaden.challenge.api.dto.ProductSummary;

public class ProductSummaryBuilder {
    private String name;
    private Integer categoryCode;
    private Long price;
    private String category;
    private Double taxAmount;
    private Boolean isRefundable;

    public ProductSummaryBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductSummaryBuilder categoryCode(Integer categoryCode) {
        this.categoryCode = categoryCode;
        return this;
    }

    public ProductSummaryBuilder price(Long price) {
        this.price = price;
        return this;
    }

    public ProductSummaryBuilder category(String category) {
        this.category = category;
        return this;
    }

    public ProductSummaryBuilder taxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public ProductSummaryBuilder isRefundable(Boolean isRefundable) {
        this.isRefundable = isRefundable;
        return this;
    }


    public ProductSummary build() {
        ProductSummary productSummary = new ProductSummary();
        productSummary.setName(name);
        productSummary.setCategoryCode(categoryCode);
        productSummary.setPrice(price);
        productSummary.setCategory(category);
        productSummary.setTaxAmount(taxAmount);
        productSummary.setIsRefundable(isRefundable);
        productSummary.setAmount(price + taxAmount);

        return productSummary;
    }

}
