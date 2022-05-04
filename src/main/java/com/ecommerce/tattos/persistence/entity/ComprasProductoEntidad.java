package com.ecommerce.tattos.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "compras_productos")
public class ComprasProductoEntidad {

    @EmbeddedId
    private ComprasProductoPK id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private CompraEntidad compraEntidad;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductoEntidad productoEntidad;
}
