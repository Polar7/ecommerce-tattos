package com.ecommerce.tattos.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Clase que moldea un tipo de producto
 */
@Getter @Setter
public class TipoProducto {

    /**
     * Id del tipo de producto
     */
    private Long idTipoProducto;

    /**
     * Descripcion del tipo de producto
     */
    private String descripcion;

    /**
     * Lista de productos que tienen el mismo tipo producto
     */
    private List<Producto> productos;

}
