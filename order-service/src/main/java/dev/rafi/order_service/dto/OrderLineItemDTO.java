package dev.rafi.order_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemDTO {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
