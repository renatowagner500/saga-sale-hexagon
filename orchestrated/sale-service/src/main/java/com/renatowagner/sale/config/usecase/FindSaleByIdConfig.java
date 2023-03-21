package com.renatowagner.sale.config.usecase;

import com.renatowagner.sale.adapters.out.FindSaleByIdAdapter;
import com.renatowagner.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {
    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(FindSaleByIdAdapter findSaleByIdAdapter) {
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }
}
