package com.desafioTecnico.controller;

import com.desafioTecnico.models.Price;
import com.desafioTecnico.response.PriceResponse;
import com.desafioTecnico.services.PriceService;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * Controlador REST que gestiona las solicitudes relacionadas con los precios.
 * Proporciona endpoints para obtener precios según ciertos parámetros.
 */

@RestController
@RequestMapping("/api/price")
@Slf4j
public class PriceController {

    private final PriceService priceService;

    /**
     * Constructor del controlador de precios.
     * @param priceService Servicio de precios.
     */
    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Endpoint para obtener el precio según los parámetros proporcionados.
     * @param brandId Identificador de la marca.
     * @param productId Identificador del producto.
     * @param applicationDate Fecha de aplicación.
     * @return ResponseEntity con el precio obtenido o una respuesta de error si no se encuentra ningún precio.
     */
    @GetMapping("/listar")
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm:ss") Date applicationDate) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            log.info("El usuario que está realizando la consulta es: " + username);

            List<Price> prices = priceService.getPriceByParameters(brandId, productId, applicationDate);

            if (prices.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Price price = prices.get(0);
            PriceResponse response = new PriceResponse(
                    price.getProductId(),
                    price.getBrandId(),
                    price.getPriceList(),
                    price.getStartDate(),
                    price.getEndDate(),
                    price.getPrice(),
                    price.getCurrency()
            );

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
