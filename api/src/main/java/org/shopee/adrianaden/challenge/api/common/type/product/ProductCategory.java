package org.shopee.adrianaden.challenge.api.common.type.product;

public class ProductCategory {

    private String name ;
    private Boolean isRefundable;


    public ProductCategory() {
        this("Uncategorized Product", Boolean.FALSE);
    }

    protected ProductCategory(String name, Boolean isRefundable) {
        this.name = name;
        this.isRefundable = isRefundable;
    }

    public Double calculateTax(Long price) {
        return  price * 0.0;
    }

    public String getName() {
        return name;
    }

    public Boolean isRefundable() {
        return isRefundable;
    }
}
