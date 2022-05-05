package com.ecommerce.tattos.persistence.crud;

import com.ecommerce.tattos.persistence.entity.ProductoEntidad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductoCrudRepository extends CrudRepository<ProductoEntidad, Long> {

    /**
     * Retorna una lista de productos ordenada por nombre dado su id de categoria
     * @param idTipoProducto Id categoria de los productos
     * @return Lista de productos con determinado id ordenados por nombre
     */
    List<ProductoEntidad> findByIdTipoProductoOrderByNombreAsc(Long idTipoProducto);

    /**
     * Retorna una lista de productos que tengan un stock menor al recibido por parametro
     * @param cantidadStock Cantidad de stock deseada
     * @return Lista de productos con un stock menor al recibido por parametro
     */
    Optional<List<ProductoEntidad>> findByCantidadStockLessThan(Long cantidadStock);
}
