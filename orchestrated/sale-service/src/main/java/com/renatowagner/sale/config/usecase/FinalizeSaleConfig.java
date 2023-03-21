package com.renatowagner.sale.config.usecase;

import com.renatowagner.sale.application.core.usecase.FinalizeSaleUseCase;
import com.renatowagner.sale.application.core.usecase.FindSaleByIdUseCase;
import com.renatowagner.sale.application.ports.out.SaveSaleOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {
    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(FindSaleByIdUseCase findSaleByIdUseCase,
                                                   SaveSaleOutputPort saveSaleOutputPort) {
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleOutputPort);
    }
}
