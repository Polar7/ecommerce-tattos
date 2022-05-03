package com.ecommerce.tattos.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Clase que moldea un cliente
 */
@Getter @Setter
public class Cliente {

    /**
     * Id del cliente
     */
    private String idCliente;

    /**
     * Nombre del cliente
     */
    private String nombreCompleto;

    /**
     * Correo del cliente
     */
    private String correo;

    /**
     * Lista de compras del cliente
     */
    private List<Compra> compras;

}
