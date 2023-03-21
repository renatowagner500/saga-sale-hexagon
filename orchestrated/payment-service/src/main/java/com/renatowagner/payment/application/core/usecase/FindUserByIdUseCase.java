package com.renatowagner.payment.application.core.usecase;

import com.renatowagner.payment.application.core.domain.User;
import com.renatowagner.payment.application.ports.in.FindUserByIdInputPort;
import com.renatowagner.payment.application.ports.out.FindUserByIdOutputPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private FindUserByIdOutputPort findUserByIdOutputPort;

    public FindUserByIdUseCase(FindUserByIdOutputPort findUserByIdOutputPort) {
        this.findUserByIdOutputPort = findUserByIdOutputPort;
    }

    @Override
    public User find(final Integer id) {
        return findUserByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado!")
        );
    }
}
