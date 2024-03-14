package com.desafioTecnico.services;

import com.desafioTecnico.models.Price;

import java.util.Date;
import java.util.List;

/**
 * Servicio que maneja la lógica de negocio relacionada con los precios.
 * Provee métodos para obtener precios según diferentes parámetros.
 */
public interface PriceService {

    /**
     * Obtiene precios según el identificador de marca, identificador de producto y fecha de aplicación proporcionados.
     * @param brandId Identificador de la marca.
     * @param productId Identificador del producto.
     * @param applicationDate Fecha de aplicación.
     * @return Lista de precios.
     */
    public List<Price> getPriceByParameters(Long brandId, Long productId, Date applicationDate);
}
