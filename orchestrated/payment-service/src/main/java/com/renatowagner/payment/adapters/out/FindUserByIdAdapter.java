package com.renatowagner.payment.adapters.out;

import com.renatowagner.payment.adapters.out.repository.UserRepository;
import com.renatowagner.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.renatowagner.payment.application.core.domain.User;
import com.renatowagner.payment.application.ports.out.FindUserByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(Integer id) {
        var userEntity = userRepository.findById(id);
        return userEntity.map(userEntityMapper::toUser);
    }
}
