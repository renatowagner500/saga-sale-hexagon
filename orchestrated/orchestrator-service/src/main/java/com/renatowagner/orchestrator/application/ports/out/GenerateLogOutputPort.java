package com.renatowagner.orchestrator.application.ports.out;

public interface GenerateLogOutputPort {
    void info(String info);

    void error(String error, Exception exception);
}
