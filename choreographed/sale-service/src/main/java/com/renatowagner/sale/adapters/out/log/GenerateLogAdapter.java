package com.renatowagner.sale.adapters.out.log;

import com.renatowagner.sale.application.ports.out.GenerateLogOutputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenerateLogAdapter implements GenerateLogOutputPort {
    @Override
    public void info(String info) {
        log.info(info);
    }

    @Override
    public void error(String error, Exception exception) {
        log.error(error, exception);
    }
}
