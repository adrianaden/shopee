package org.shopee.adrianaden.challenge.api.common.type;

import org.shopee.adrianaden.challenge.api.common.type.product.ProductCategory;

public class TypeProcessor {

    private TypeProcessor(){
        throw new IllegalStateException("Utility class!");
    }

    public static ProductCategory findProductCategoryClass(Integer value) {
        try {
            for (int i = 0; i < ProductCategoryType.values().length; i++) {
                ProductCategoryType productCategoryType = ProductCategoryType.values()[i];
                if (productCategoryType.getProductCategoryCode() == value) {
                    return productCategoryType.getProductTypeClass()
                            .getConstructor()
                            .newInstance();
                }
            }
        }

        // return default value
        // default value is very depend on requirements

        catch (Exception e) {
            return new ProductCategory();
        }
        return new ProductCategory();
    }
}
