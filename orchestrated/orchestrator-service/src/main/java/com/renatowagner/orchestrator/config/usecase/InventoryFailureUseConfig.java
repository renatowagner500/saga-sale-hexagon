package com.renatowagner.orchestrator.config.usecase;

import com.renatowagner.orchestrator.adapters.out.SendToTopicAdapter;
import com.renatowagner.orchestrator.application.core.usecase.InventoryFailureUseCase;
import com.renatowagner.orchestrator.application.ports.out.GenerateLogOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryFailureUseConfig {

    @Bean
    public InventoryFailureUseCase inventoryFailureUseCase(SendToTopicAdapter sendToTopicAdapter, GenerateLogOutputPort generateLogOutputPort) {
        return new InventoryFailureUseCase(sendToTopicAdapter, generateLogOutputPort);
    }
}
