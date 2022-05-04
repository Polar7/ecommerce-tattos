package com.ecommerce.tattos.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que moldea la entidad Compras
 */
@Getter @Setter
@Entity
@Table(name = "compras")
public class CompraEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private Character medioPago;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private ClienteEntidad clienteEntidad;

    @OneToMany(mappedBy = "compraEntidad", cascade = {CascadeType.ALL})
    private List<ComprasProductoEntidad> productos;
}
