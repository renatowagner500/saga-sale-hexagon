package com.renatowagner.payment.application.ports.out;

import com.renatowagner.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {
    Optional<User> find(final Integer id);
}
