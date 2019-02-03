package org.shopee.adrianaden.challenge.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProductSummary {
    private String name;
    private Integer categoryCode;
    private Long price;
    private String category;
    private Double taxAmount;
    private Boolean isRefundable;
}
