package com.renatowagner.orchestrator.config.usecase;

import com.renatowagner.orchestrator.adapters.out.SendToTopicAdapter;
import com.renatowagner.orchestrator.application.core.usecase.CreatedSaleUseCase;
import com.renatowagner.orchestrator.application.ports.out.GenerateLogOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleUseConfig {

    @Bean
    public CreatedSaleUseCase createCreateSaleUseCase(SendToTopicAdapter sendToTopicAdapter, GenerateLogOutputPort generateLogOutputPort) {
        return new CreatedSaleUseCase(sendToTopicAdapter, generateLogOutputPort);
    }
}
