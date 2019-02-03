package org.shopee.adrianaden.challenge.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.shopee.adrianaden.challenge.api.common.builder.ProductSummaryBuilder;

@Setter
@Getter
public class ProductSummary {
    private String name;
    private Integer categoryCode;
    private Long price;
    private String category;
    private Double taxAmount;
    private Boolean isRefundable;
    private Double amount;

    public static ProductSummaryBuilder builder(){
        return new ProductSummaryBuilder();
    }
}
