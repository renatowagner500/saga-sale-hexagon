package com.renatowagner.sale.application.core.usecase;

import com.renatowagner.sale.application.core.domain.Sale;
import com.renatowagner.sale.application.core.domain.enums.SaleEvent;
import com.renatowagner.sale.application.core.domain.enums.SaleStatus;
import com.renatowagner.sale.application.ports.in.CreateSaleInputPort;
import com.renatowagner.sale.application.ports.out.SaveSaleOutputPort;
import com.renatowagner.sale.application.ports.out.SendCreateSaleOutputPort;

public class CreateSaleUseCase implements CreateSaleInputPort {
    private final SaveSaleOutputPort saveSaleOutputPort;
    private final SendCreateSaleOutputPort sendSaleOutputPort;

    public CreateSaleUseCase(SaveSaleOutputPort saveSaleOutputPort,
                             SendCreateSaleOutputPort sendSaleOutputPort) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendSaleOutputPort = sendSaleOutputPort;
    }

    @Override
    public void create(Sale sale) {
        sale.setStatus(SaleStatus.PENDING);
        var saleResponse = saveSaleOutputPort.save(sale);
        sendSaleOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
