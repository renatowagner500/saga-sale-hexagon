package com.renatowagner.sale.application.ports.in;

import com.renatowagner.sale.application.core.domain.Sale;

public interface CancelSaleInputPort {
    void cancel(Sale sale);
}
