package com.ecommerce.tattos.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que moldea un producto
 */
@Getter @Setter
public class Producto {

    /**
     * Id del producto
     */
    private Long idProducto;

    /**
     * Id del tipo de producto
     */
    private Long idTipoProducto;

    /**
     * Nombre del producto
     */
    private String nombre;

    /**
     * Precio del producto
     */
    private Double precioVenta;

    /**
     * Stock del producto
     */
    private Integer cantidadStock;

    /**
     * Url de la imagen del producto
     */
    private String urlImagen;

}
