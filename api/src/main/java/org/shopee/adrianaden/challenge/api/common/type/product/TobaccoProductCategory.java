package org.shopee.adrianaden.challenge.api.common.type.product;

public class TobaccoProductCategory extends ProductCategory {

    public TobaccoProductCategory() {
        super("Tobacco", Boolean.FALSE);
    }

    @Override
    public Double calculateTax(Long price) {
        return 10 + ((double) 2 / 100 * price);
    }
}
