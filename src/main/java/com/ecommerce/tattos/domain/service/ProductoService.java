package com.ecommerce.tattos.domain.service;

import com.ecommerce.tattos.domain.Producto;
import com.ecommerce.tattos.domain.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de Producto
 */
@Service
public class ProductoService {

    //Al llamar la interfaz, lo que se inyecta verdaderamente es la implementacion ProductoRepository
    private IProductoRepository iProductoRepository;

    @Autowired
    public ProductoService(IProductoRepository iProductoRepository) {
        this.iProductoRepository = iProductoRepository;
    }

    /**
     * Retorna todos los productos
     * @return todos los productos
     */
    public List<Producto> getAll(){
        return iProductoRepository.getAll();
    }

    /**
     * Obtiene un producto dado su Id
     * @param productoId Id del producto
     * @return El producto con el id proporcionado
     */
    public Optional<Producto> getProduct(int productoId) {
        return iProductoRepository.getProduct(productoId);
    }

    /**
     * Devuelve la lista de productos que pertenecen a una misma categoria
     * @param categoriaId Categoria de productos a retornar
     * @return Lista de productos con la categoria recibida por parametro
     */
    public Optional<List<Producto>> getByCategory(int categoriaId){
        return iProductoRepository.getByCategory(categoriaId);
    }

    /**
     * Crea un nuevo producto
     * @param producto Producto a crear
     * @return El producto creado
     */
    public Producto save(Producto producto){
        return iProductoRepository.save(producto);
    }

    /**
     * Elimina un producto dado su id
     * @param productoId Id del producto a borrar
     * @return True si se logra borrar, false si el producto no existe
     */
    public boolean delete(int productoId){
        try {
            iProductoRepository.delete(productoId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
