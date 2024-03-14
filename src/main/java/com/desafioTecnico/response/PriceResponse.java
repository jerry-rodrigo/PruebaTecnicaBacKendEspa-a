package com.desafioTecnico.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Clase que representa la respuesta de un precio.
 * Contiene los campos relevantes de un precio para ser devueltos en la respuesta REST.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponse {

    private Long productId;
    private Long brandId;
    private Integer priceList;
    private Date startDate;
    private Date endDate;
    private Double price;
    private String currency;
}
