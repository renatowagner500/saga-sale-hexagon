package com.renatowagner.payment.config.usecase;

import com.renatowagner.payment.adapters.out.SavePaymentAdapter;
import com.renatowagner.payment.adapters.out.MessagingAdapter;
import com.renatowagner.payment.adapters.out.UpdateUserAdapter;
import com.renatowagner.payment.adapters.out.log.GenerateLogAdapter;
import com.renatowagner.payment.application.core.usecase.FindUserByIdUseCase;
import com.renatowagner.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {


    @Bean
    public SalePaymentUseCase salePaymentUseCase(FindUserByIdUseCase findUserByIdUseCase, UpdateUserAdapter updateUserAdapter, SavePaymentAdapter savePaymentAdapter, MessagingAdapter sendValidatedAdapter, GenerateLogAdapter generateLogAdapter) {
        return new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter, savePaymentAdapter, sendValidatedAdapter, generateLogAdapter);
    }
}
