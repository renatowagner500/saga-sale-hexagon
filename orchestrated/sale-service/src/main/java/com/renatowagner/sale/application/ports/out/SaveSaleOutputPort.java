package com.renatowagner.sale.application.ports.out;

import com.renatowagner.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {
    Sale save(Sale sale);
}
