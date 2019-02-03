package org.shopee.adrianaden.challenge.api.common.builder;

import org.shopee.adrianaden.challenge.api.dto.BillSummary;
import org.shopee.adrianaden.challenge.api.dto.ProductSummary;

import java.util.List;

public class BillSummaryBuilder {
    private List<ProductSummary> productSummaries;

    public BillSummaryBuilder productSummaries(List<ProductSummary> productSummaries) {
        this.productSummaries = productSummaries;
        return this;
    }

    public BillSummary build() {

        Long priceSubTotal = productSummaries.stream().mapToLong(ProductSummary::getPrice).sum();
        Double taxSubTotal = productSummaries.stream().mapToDouble(ProductSummary::getTaxAmount).sum();
        Double grandSubTotal = priceSubTotal - taxSubTotal;

        BillSummary billSummary = new BillSummary();
        billSummary.setProductSummaries(productSummaries);
        billSummary.setPriceSubTotal(priceSubTotal);
        billSummary.setTaxSubTotal(taxSubTotal);
        billSummary.setGrandSubTotal(grandSubTotal);

        return billSummary;
    }
}
