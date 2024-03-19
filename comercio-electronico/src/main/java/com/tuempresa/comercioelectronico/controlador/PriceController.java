package com.tuempresa.comercioelectronico.controlador;

import com.tuempresa.comercioelectronico.modelo.Price;
import com.tuempresa.comercioelectronico.servicio.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public Price getPrice(@RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
                          @RequestParam("productId") Integer productId,
                          @RequestParam("brandId") Integer brandId) {
        return priceService.findApplicablePrice(applicationDate, productId, brandId);
    }
}
