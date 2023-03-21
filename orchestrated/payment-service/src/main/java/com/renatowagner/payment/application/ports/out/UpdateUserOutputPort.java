package com.renatowagner.payment.application.ports.out;

import com.renatowagner.payment.application.core.domain.User;

public interface UpdateUserOutputPort {
    void Update(User user);
}
