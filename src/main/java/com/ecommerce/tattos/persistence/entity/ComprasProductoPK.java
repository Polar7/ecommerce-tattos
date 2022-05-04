package com.ecommerce.tattos.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Clase que moldea una llave primaria compuesta de ComprasProducto
 */
@Getter @Setter
@Embeddable
public class ComprasProductoPK implements Serializable {

    private static final long serialVersionUID = -2145479604343286721L;

    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_producto")
    private Long idProducto;
}
