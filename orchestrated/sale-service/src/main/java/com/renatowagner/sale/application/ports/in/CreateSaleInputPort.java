package com.renatowagner.sale.application.ports.in;

import com.renatowagner.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {
    void create(Sale sale);
}
