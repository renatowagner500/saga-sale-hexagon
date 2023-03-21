package com.renatowagner.payment.application.ports.in;

import com.renatowagner.payment.application.core.domain.User;

public interface FindUserByIdInputPort {
    User find(final Integer id);
}
