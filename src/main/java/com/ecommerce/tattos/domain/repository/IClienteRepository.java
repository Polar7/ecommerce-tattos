package com.ecommerce.tattos.domain.repository;

import com.ecommerce.tattos.domain.Cliente;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que determina las reglas que debe cumplir la persistencia de Cliente
 */
public interface IClienteRepository {

    /**
     * Devuelve todos los clientes registrados
     * @return Lista con todos los clientes
     */
    List<Cliente> getAll();


    /**
     * Obtiene un cliente dado su Id
     * @param clienteId Id del cliente
     * @return El cliente con el id proporcionado
     */
    Optional<Cliente> getCliente(String clienteId);


    /**
     * Guarda un nuevo cliente
     * @param cliente CLiente a guardar
     * @return EL cliente guardado
     */
    Cliente save(Cliente cliente);

    /**
     * Borra un cliente dado su id
     * @param clienteId Id del cliente
     */
    void delete(String clienteId);
}
