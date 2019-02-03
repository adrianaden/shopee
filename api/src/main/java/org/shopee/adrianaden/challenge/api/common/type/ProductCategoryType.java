package org.shopee.adrianaden.challenge.api.common.type;

import org.shopee.adrianaden.challenge.api.common.type.product.EntertainmentProductCategory;
import org.shopee.adrianaden.challenge.api.common.type.product.FoodBeverageProductCategory;
import org.shopee.adrianaden.challenge.api.common.type.product.ProductCategory;
import org.shopee.adrianaden.challenge.api.common.type.product.TobaccoProductCategory;

public enum ProductCategoryType {
    /* 0 */ UNCATEGORIZED(0, ProductCategory.class),
    /* 1 */ FOOD_BEVERAGE(1, FoodBeverageProductCategory.class),
    /* 2 */ TOBACCO(2, TobaccoProductCategory.class),
    /* 3 */ ENTERTAINMENT(3, EntertainmentProductCategory.class);

    private Integer productCategoryCode;
    private Class<? extends ProductCategory> productTypeClass;

    ProductCategoryType(Integer productCategoryCode, Class<? extends ProductCategory> productTypeClass) {
        this.productCategoryCode = productCategoryCode;
        this.productTypeClass = productTypeClass;
    }

    public Class<? extends ProductCategory> getProductTypeClass() {
        return productTypeClass;
    }

    public Integer getProductCategoryCode() {
        return productCategoryCode;
    }

}
