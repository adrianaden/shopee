package org.shopee.adrianaden.challenge.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.shopee.adrianaden.challenge.api.common.builder.BillSummaryBuilder;

import java.util.List;

@Setter
@Getter
public class BillSummary {

    private List<ProductSummary> productSummaries;

    private Long priceSubTotal;
    private Double taxSubTotal;
    private Double grandSubTotal;

    public static BillSummaryBuilder builder(){
        return new BillSummaryBuilder();
    }
}
