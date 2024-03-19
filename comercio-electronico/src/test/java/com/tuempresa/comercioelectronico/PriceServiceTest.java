package com.tuempresa.comercioelectronico;

import com.tuempresa.comercioelectronico.modelo.Price;
import com.tuempresa.comercioelectronico.repositorio.PriceRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PriceServiceTest {

    @Autowired
    private PriceRepository priceRepository;
    
    final String GREEN = "\u001B[32m";
    
    //El método runTests se encarga de llamar al servicio findProduct para comprobar el correcto funcionamiento de la aplicación
    //Todos los test que etiquetamos con @Test serán lanzados, y por tanto cada uno de ellos realiza una llamada al metodo runTest con diferentes parámetros de entrada
    private void runTests(Integer numTest, Integer productId, Integer brandId, LocalDateTime applicationDate, BigDecimal expectedPrice) {
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, brandId, applicationDate, applicationDate);

        assertThat(prices).isNotEmpty();
        Price foundPrice = prices.get(0);

        assertThat(foundPrice.getPrice()).isEqualByComparingTo(expectedPrice);
        assertThat(foundPrice.getProductId()).isEqualTo(productId);
        assertThat(foundPrice.getBrandId()).isEqualTo(brandId);

        System.out.println(String.format(GREEN+"Test %d: petición a las %s del día %s del producto %d para la marca %d (ZARA)", 
        		numTest, applicationDate.toLocalTime(), applicationDate.toLocalDate(), foundPrice.getProductId(), foundPrice.getBrandId()));
    }

    @Test
    public void test1() {
        Integer numTest = 1;
    	Integer productId = 35455;
        Integer brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        runTests(numTest, productId, brandId, applicationDate, new BigDecimal("35.50"));
    }

    @Test
    public void test2() {
    	Integer numTest = 2;
        Integer productId = 35455;
        Integer brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);
        runTests(numTest, productId, brandId, applicationDate, new BigDecimal("25.45"));
    }

    @Test
    public void test3() {
    	Integer numTest = 3;
        Integer productId = 35455;
        Integer brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);
        runTests(numTest, productId, brandId, applicationDate, new BigDecimal("35.50"));
    }

    @Test
    public void test4() {
    	Integer numTest = 4;
        Integer productId = 35455;
        Integer brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);
        runTests(numTest, productId, brandId, applicationDate, new BigDecimal("30.50"));
    }

    @Test
    public void test5() {
    	Integer numTest = 5;
        Integer productId = 35455;
        Integer brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);
        runTests(numTest, productId, brandId, applicationDate, new BigDecimal("38.95"));
    }




}
