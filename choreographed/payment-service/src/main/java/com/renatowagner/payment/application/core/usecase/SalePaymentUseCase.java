package com.renatowagner.payment.application.core.usecase;

import com.renatowagner.payment.application.core.domain.Payment;
import com.renatowagner.payment.application.core.domain.Sale;
import com.renatowagner.payment.application.core.domain.enums.SaleEvent;
import com.renatowagner.payment.application.ports.in.FindUserByIdInputPort;
import com.renatowagner.payment.application.ports.in.SalePaymentInputPort;
import com.renatowagner.payment.application.ports.out.GenerateLogOutputPort;
import com.renatowagner.payment.application.ports.out.SavePaymentOutputPort;
import com.renatowagner.payment.application.ports.out.MessagingOutputPort;
import com.renatowagner.payment.application.ports.out.UpdateUserOutputPort;

public class SalePaymentUseCase implements SalePaymentInputPort {

    private FindUserByIdInputPort findUserByIdInputPort;
    private UpdateUserOutputPort updateUserOutputPort;
    private SavePaymentOutputPort savePaymentOutputPort;
    private MessagingOutputPort messagingOutputPort;

    private GenerateLogOutputPort generateLogOutputPort;

    public SalePaymentUseCase(FindUserByIdInputPort findUserByIdInputPort,
                              UpdateUserOutputPort updateUserOutputPort,
                              SavePaymentOutputPort savePaymentOutputPort,
                              MessagingOutputPort messagingOutputPort,
                              GenerateLogOutputPort generateLogOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.messagingOutputPort = messagingOutputPort;
        this.generateLogOutputPort = generateLogOutputPort;
    }

    @Override
    public void payment(Sale sale) {
        try {
            var user = findUserByIdInputPort.find(sale.getUserId());
            if (user.getBalance().compareTo(sale.getValue()) < 0) {
                throw new RuntimeException("saldo insuficiente");
            }

            user.debitBalance(sale.getValue());
            updateUserOutputPort.Update(user);
            savePaymentOutputPort.save(buildPayment(sale));
            messagingOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
        } catch (Exception e) {
            generateLogOutputPort.error("Erro ao processar o pagamento", e);
            messagingOutputPort.send(sale, SaleEvent.FAILED_PAYMENT);
        }

    }

    private Payment buildPayment(Sale sale) {
        return new Payment(null, sale.getId(), sale.getUserId(), sale.getValue());
    }
}
