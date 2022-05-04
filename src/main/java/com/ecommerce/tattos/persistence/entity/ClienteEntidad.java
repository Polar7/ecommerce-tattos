package com.ecommerce.tattos.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Clase que moldea la entidad Producto
 */
@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    private String idCliente;

    @Column(name = "nombreCompleto")
    private String nombreCompleto;

    @Column(name = "correo")
    private String correo;
}
