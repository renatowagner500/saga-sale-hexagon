package com.renatowagner.inventory.config.usecase;

import com.renatowagner.inventory.adapters.out.MessagingInventoryAdapter;
import com.renatowagner.inventory.adapters.out.UpdateInventoryAdapter;
import com.renatowagner.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import com.renatowagner.inventory.application.core.usecase.RollBackInventoryUseCase;
import com.renatowagner.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.renatowagner.inventory.application.ports.out.MessagingInventoryOutputPort;
import com.renatowagner.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RollBackInventoryConfig {


    @Bean
    public RollBackInventoryUseCase rollBackInventoryUseCase(FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
                                                             UpdateInventoryAdapter updateInventoryAdapter,
                                                             MessagingInventoryAdapter messagingInventoryAdapter){
        return  new RollBackInventoryUseCase(findInventoryByProductIdUseCase,updateInventoryAdapter,messagingInventoryAdapter);

    }

}
