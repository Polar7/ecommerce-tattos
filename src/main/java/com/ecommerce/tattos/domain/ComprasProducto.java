package com.ecommerce.tattos.domain;


import lombok.Getter;
import lombok.Setter;

/**
 * Clase que moldea las compras con sus productos
 */
@Getter @Setter
public class ComprasProducto {

    /**
     * Id del producto
     */
    private Long idProducto;

    /**
     * Id de la compra
     */
    private Long idCompra;

    /**
     * Cantidad de productos en la compra
     */
    private Integer cantidad;

    /**
     * Total de los productos en la compra
     */
    private double total;

}
