package com.ecommerce.tattos.domain.repository;

import com.ecommerce.tattos.domain.Compra;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que determina las reglas que debe cumplir la persistencia de Compra
 */
public interface ICompraRepository {

    /**
     * Devuelve todas las compras realizadas
     * @return Todas las compras
     */
    List<Compra> getAll();

    /**
     * Devuelve todas las compras hechas por determinado cliente
     * @param clienteId Id del cliente
     * @return Las compras hechas por un cliente dado su id
     */
    Optional<List<Compra>> getByCliente(String clienteId);

    /**
     * Crea una nueva compra
     * @param compra Compra a crear
     * @return La compra creada
     */
    Compra save(Compra compra);
}
