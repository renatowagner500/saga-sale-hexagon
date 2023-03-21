package com.renatowagner.sale.application.core.usecase;

import com.renatowagner.sale.application.core.domain.Sale;
import com.renatowagner.sale.application.core.domain.enums.SaleStatus;
import com.renatowagner.sale.application.ports.in.CancelSaleInputPort;
import com.renatowagner.sale.application.ports.in.FindSaleByidInputPort;
import com.renatowagner.sale.application.ports.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private FindSaleByidInputPort findSaleByidInputPort;
    private SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(FindSaleByidInputPort findSaleByidInputPort, SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByidInputPort = findSaleByidInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void cancel(Sale sale) {
        var saleResponse = findSaleByidInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.CANCELED);
        saveSaleOutputPort.save(saleResponse);
    }
}
