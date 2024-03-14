package com.desafioTecnico.services.impl;

import com.desafioTecnico.models.Price;
import com.desafioTecnico.repositories.IPriceRepository;
import com.desafioTecnico.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private IPriceRepository priceRepository;

    /**
     * Obtiene precios según el identificador de marca, identificador de producto y fecha de aplicación proporcionados.
     * @param brandId Identificador de la marca.
     * @param productId Identificador del producto.
     * @param applicationDate Fecha de aplicación.
     * @return Lista de precios.
     */
    public List<Price> getPriceByParameters(Long brandId, Long productId, Date applicationDate) {
        return priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                brandId, productId, applicationDate, applicationDate);
    }
}
