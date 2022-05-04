package com.ecommerce.tattos.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Clase que moldea la entidad Tipo producto
 */
@Getter @Setter
@Entity
@Table(name = "tipos_productos")
public class TipoProductoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_producto")
    private Long idTipoProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tipoProductoEntidad")
    private List<ProductoEntidad> productos;
}
