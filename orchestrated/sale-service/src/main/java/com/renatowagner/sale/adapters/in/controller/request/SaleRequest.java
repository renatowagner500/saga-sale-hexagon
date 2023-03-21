package com.renatowagner.sale.adapters.in.controller.request;

import com.renatowagner.sale.application.core.domain.enums.SaleStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest {

    @NotNull
    private Integer productId;
    @NotNull
    private Integer userId;
    @NotNull
    private BigDecimal value;
    @NotNull
    private Integer quantity;


}
