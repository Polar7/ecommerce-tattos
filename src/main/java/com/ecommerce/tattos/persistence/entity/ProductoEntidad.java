package com.ecommerce.tattos.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Clase que moldea la entidad Producto
 */
@Getter @Setter
@Entity
@Table(name = "productos")
public class ProductoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "id_tipo_producto")
    private Long idTipoProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    @Column(name = "url_imagen")
    private String urlImagen;

    @ManyToOne
    @JoinColumn(name = "id_tipo_producto", insertable = false, updatable = false)
    private TipoProductoEntidad tipoProductoEntidad;

    @OneToMany(mappedBy = "productoEntidad")
    private List<ComprasProductoEntidad> compras;
}
