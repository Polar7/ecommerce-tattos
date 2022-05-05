package com.ecommerce.tattos.domain.repository;

import com.ecommerce.tattos.domain.Producto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que determina las reglas que debe cumplir la persistencia de Producto
 */
public interface IProductoRepository {

    /**
     * Devuelve todos los productos
     * @return Todas las compras
     */
    List<Producto> getAll();

    /**
     * Obtiene un producto dado su Id
     * @param productoId Id del producto
     * @return El producto con el id proporcionado
     */
    Optional<Producto> getProduct(Long productoId);

    /**
     * Devuelve la lista de productos que pertenecen a una misma categoria
     * @param categoriaId Categoria de productos a retornar
     * @return Lista de productos con la categoria recibida por parametro
     */
    Optional<List<Producto>> getByCategory(Long categoriaId);

    /**
     * Crea un nuevo producto
     * @param producto Producto a crear
     * @return El producto creado
     */
    Producto save(Producto producto);

    /**
     * Elimina un producto dado su id
     * @param productId Id del producto a borrar
     */
    void delete(Long productId);
}
