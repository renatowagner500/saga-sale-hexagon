package com.renatowagner.sale.application.core.usecase;

import com.renatowagner.sale.application.core.domain.Sale;
import com.renatowagner.sale.application.core.domain.enums.SaleStatus;
import com.renatowagner.sale.application.ports.in.FinalizeSaleInputPort;
import com.renatowagner.sale.application.ports.in.FindSaleByidInputPort;
import com.renatowagner.sale.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private FindSaleByidInputPort findSaleByidInputPort;
    private SaveSaleOutputPort saveSaleOutputPort;

    public FinalizeSaleUseCase(FindSaleByidInputPort findSaleByidInputPort, SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByidInputPort = findSaleByidInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void finalize(Sale sale) {
        var saleResponse = findSaleByidInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.FINALIZED);
        saveSaleOutputPort.save(saleResponse);
    }

}
