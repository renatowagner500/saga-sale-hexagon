package com.renatowagner.orchestrator.config.usecase;

import com.renatowagner.orchestrator.adapters.out.SendToTopicAdapter;
import com.renatowagner.orchestrator.application.core.usecase.InventoryPreparedUseCase;
import com.renatowagner.orchestrator.application.ports.out.GenerateLogOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryPreparedUseConfig {

    @Bean
    public InventoryPreparedUseCase inventoryPreparedUseCase(SendToTopicAdapter sendToTopicAdapter, GenerateLogOutputPort generateLogOutputPort) {
        return new InventoryPreparedUseCase(sendToTopicAdapter, generateLogOutputPort);
    }
}
