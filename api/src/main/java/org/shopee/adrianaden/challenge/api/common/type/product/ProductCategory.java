package org.shopee.adrianaden.challenge.api.common.type.product;

public class ProductCategory {

    private Double taxAmount ;
    private String name ;
    private Boolean isRefundable;


    public ProductCategory() {
        this(0.0, "Uncategorized Product", Boolean.FALSE);
    }

    protected ProductCategory(Double taxAmount, String name, Boolean isRefundable) {
        this.taxAmount = taxAmount;
        this.name = name;
        this.isRefundable = isRefundable;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public String getName() {
        return name;
    }

    public Boolean isRefundable() {
        return isRefundable;
    }
}
