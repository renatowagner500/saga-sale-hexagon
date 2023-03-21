package com.renatowagner.payment.config.usecase;

import com.renatowagner.payment.adapters.out.FindUserByIdAdapter;
import com.renatowagner.payment.application.core.usecase.FindUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {
    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(FindUserByIdAdapter findUserByIdAdapter) {
        return new FindUserByIdUseCase(findUserByIdAdapter);

    }
}
