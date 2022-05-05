package com.ecommerce.tattos.persistence.crud;

import com.ecommerce.tattos.persistence.entity.CompraEntidad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ICompraCrudRepository extends CrudRepository<CompraEntidad, Long> {

    /**
     * Retorna la lista de compras de un cliente dado su id
     * @param idCliente Id del cliente
     * @return Lista de compras del cliente dado
     */
    //Query method
    Optional<List<CompraEntidad>> findByIdCliente(String idCliente);
}
