package com.renatowagner.inventory.config.usecase;

import com.renatowagner.inventory.adapters.out.MessagingInventoryAdapter;
import com.renatowagner.inventory.adapters.out.UpdateInventoryAdapter;
import com.renatowagner.inventory.adapters.out.log.GenerateLogAdapter;
import com.renatowagner.inventory.application.core.usecase.DebitInventoryUseCase;
import com.renatowagner.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import com.renatowagner.inventory.application.ports.out.GenerateLogOutputPort;
import com.renatowagner.inventory.application.ports.out.MessagingInventoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
                                                       UpdateInventoryAdapter updateInventoryAdapter,
                                                       MessagingInventoryAdapter messagingInventoryAdapter,
                                                       GenerateLogAdapter generateLogAdapter) {
        return new DebitInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter, messagingInventoryAdapter, generateLogAdapter);
    }
}
