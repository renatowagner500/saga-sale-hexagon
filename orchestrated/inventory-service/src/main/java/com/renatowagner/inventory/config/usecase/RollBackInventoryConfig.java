package com.renatowagner.inventory.config.usecase;

import com.renatowagner.inventory.adapters.out.UpdateInventoryAdapter;
import com.renatowagner.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import com.renatowagner.inventory.application.core.usecase.RollBackInventoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RollBackInventoryConfig {


    @Bean
    public RollBackInventoryUseCase rollBackInventoryUseCase(FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
                                                             UpdateInventoryAdapter updateInventoryAdapter) {
        return new RollBackInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter);

    }

}
