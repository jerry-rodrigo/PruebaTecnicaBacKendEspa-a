package com.desafioTecnico.repositories;

import com.desafioTecnico.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Price.
 * Proporciona métodos para interactuar con la base de datos y realizar operaciones CRUD relacionadas con la entidad Price.
 */
@Repository
public interface IPriceRepository extends JpaRepository<Price, Long> {

    /**
     * Busca los precios por identificador de marca, identificador de producto y fechas de inicio y fin.
     * Ordena los resultados por prioridad de forma descendente.
     * @param brandId Identificador de la marca.
     * @param productId Identificador del producto.
     * @param startDate Fecha de inicio.
     * @param endDate Fecha de fin.
     * @return Lista de precios.
     */
    List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long brandId, Long productId, Date startDate, Date endDate);
}
