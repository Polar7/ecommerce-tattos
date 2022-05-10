package com.ecommerce.tattos.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Clase que moldea la entidad Cliente
 */
@Getter @Setter
@Entity
@Table(name = "clientes")
public class ClienteEntidad {

    @Id
    @Column(name = "id_cliente")
    private String idCliente;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "correo")
    private String correo;

    @OneToMany(mappedBy = "clienteEntidad")
    private List<CompraEntidad> compras;
}
