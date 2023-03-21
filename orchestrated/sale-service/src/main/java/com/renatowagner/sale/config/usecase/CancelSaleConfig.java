package com.renatowagner.sale.config.usecase;

import com.renatowagner.sale.application.core.usecase.CancelSaleUseCase;
import com.renatowagner.sale.application.core.usecase.FindSaleByIdUseCase;
import com.renatowagner.sale.application.ports.out.SaveSaleOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(FindSaleByIdUseCase findSaleByIdUseCase,
                                               SaveSaleOutputPort saveSaleOutputPort) {
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleOutputPort);
    }
}
