package com.renatowagner.sale.adapters.in.controller.mapper;

import com.renatowagner.sale.adapters.in.controller.request.SaleRequest;
import com.renatowagner.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
}
