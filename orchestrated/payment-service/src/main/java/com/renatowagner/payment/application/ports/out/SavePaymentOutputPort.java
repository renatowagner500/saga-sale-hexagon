package com.renatowagner.payment.application.ports.out;

import com.renatowagner.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {
    void save(Payment payment);
}
