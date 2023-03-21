package com.renatowagner.sale.adapters.out;

import com.renatowagner.sale.adapters.out.repository.SaleRepository;
import com.renatowagner.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.renatowagner.sale.application.core.domain.Sale;
import com.renatowagner.sale.application.ports.out.SaveSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleAdapter implements SaveSaleOutputPort {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        var saleEntity = saleEntityMapper.toSaleEntity(sale);
        var saleEntityResponse = saleRepository.save(saleEntity);
        return saleEntityMapper.toSale(saleEntityResponse);
    }
}
