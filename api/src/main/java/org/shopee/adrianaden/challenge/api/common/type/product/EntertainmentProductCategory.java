package org.shopee.adrianaden.challenge.api.common.type.product;

public class EntertainmentProductCategory extends ProductCategory {

    public EntertainmentProductCategory() {
        super("Entertainment", Boolean.FALSE);
    }

    @Override
    public Double calculateTax(Long price) {
        if (price > 0 && price < 100) {
            return 0.0;
        } else {
            return (double) 1 / 100 * (price - 100);
        }
    }
}
