package com.renatowagner.sale.application.core.usecase;

import com.renatowagner.sale.application.core.domain.Sale;
import com.renatowagner.sale.application.ports.in.FindSaleByidInputPort;
import com.renatowagner.sale.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByidInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;


    public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale find(Integer id) {
        return findSaleByIdOutputPort.find(id).orElseThrow(() ->
                new RuntimeException("Venda nao encontrada"));
    }
}
