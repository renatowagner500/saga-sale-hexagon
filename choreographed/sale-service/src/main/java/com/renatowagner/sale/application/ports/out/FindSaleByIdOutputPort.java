package com.renatowagner.sale.application.ports.out;

import com.renatowagner.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(Integer id);
}
