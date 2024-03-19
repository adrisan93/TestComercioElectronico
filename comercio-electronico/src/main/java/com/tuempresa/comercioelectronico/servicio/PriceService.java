package com.tuempresa.comercioelectronico.servicio;

import com.tuempresa.comercioelectronico.modelo.Price;
import com.tuempresa.comercioelectronico.repositorio.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Price findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, brandId, applicationDate, applicationDate);
        return prices.isEmpty() ? null : prices.get(0);
    }
}
