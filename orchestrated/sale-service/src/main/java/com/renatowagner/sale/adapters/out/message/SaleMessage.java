package com.renatowagner.sale.adapters.out.message;

import com.renatowagner.sale.application.core.domain.Sale;
import com.renatowagner.sale.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {
    private Sale sale;
    private SaleEvent event;
}
