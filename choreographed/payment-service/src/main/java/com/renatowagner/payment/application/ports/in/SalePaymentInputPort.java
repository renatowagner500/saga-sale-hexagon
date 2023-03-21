package com.renatowagner.payment.application.ports.in;

import com.renatowagner.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {
    void payment(Sale sale);
}
