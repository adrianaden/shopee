package org.shopee.adrianaden.challenge.api.common.type.product;

public class FoodBeverageProductCategory extends ProductCategory {

    public FoodBeverageProductCategory() {
        super("Food & Beverage", Boolean.TRUE);
    }


    @Override
    public Double calculateTax(Long price) {
        return (double) price * 10/100;
    }
}
