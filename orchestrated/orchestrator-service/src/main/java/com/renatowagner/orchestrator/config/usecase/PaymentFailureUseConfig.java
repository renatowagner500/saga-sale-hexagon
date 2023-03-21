package com.renatowagner.orchestrator.config.usecase;

import com.renatowagner.orchestrator.adapters.out.SendToTopicAdapter;
import com.renatowagner.orchestrator.application.core.usecase.PaymentFailureUseCase;
import com.renatowagner.orchestrator.application.ports.out.GenerateLogOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentFailureUseConfig {

    @Bean
    public PaymentFailureUseCase paymentFailureUseCase(SendToTopicAdapter sendToTopicAdapter, GenerateLogOutputPort generateLogOutputPort) {
        return new PaymentFailureUseCase(sendToTopicAdapter, generateLogOutputPort);
    }
}