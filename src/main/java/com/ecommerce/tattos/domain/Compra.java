package com.ecommerce.tattos.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que moldea una compra
 */
@Getter @Setter
public class Compra {

    /**
     * Id de la compra
     */
    private Long idCompra;

    /**
     * Id del cliente al que pertenece la compra
     */
    private String idCliente;

    /**
     * Fecha cuando se realizó la compra
     */
    private LocalDateTime fecha;

    /**
     * Medio de pago que se utilizó en la compra
     */
    private Character medioPago;

    /**
     * Lista de compras con sus productos
     */
    private List<ComprasProducto> comprasProducto;

}
