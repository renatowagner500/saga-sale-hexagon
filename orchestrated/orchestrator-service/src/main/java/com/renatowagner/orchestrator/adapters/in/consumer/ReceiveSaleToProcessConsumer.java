package com.renatowagner.orchestrator.adapters.in.consumer;

import com.renatowagner.orchestrator.adapters.out.message.SaleMessage;
import com.renatowagner.orchestrator.application.ports.in.WorkflowInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ReceiveSaleToProcessConsumer {

    @Autowired
    private List<WorkflowInputPort> workflowInputPorts;

    @KafkaListener(topics = "tp-saga-orchestrator", groupId = "orchestrator")
    private void receive(SaleMessage saleMessage) {
        var workflow = workflowInputPorts.stream()
                .filter(it -> it.isCalledBytheEvent(saleMessage.getEvent()))
                .findFirst()
                .orElse(null);

        if (workflow != null) {
            workflow.execute(saleMessage.getSale());
        } else {
            log.error("Topico nao implementado ->"
                    + saleMessage.getEvent().toString());
        }
    }
}
