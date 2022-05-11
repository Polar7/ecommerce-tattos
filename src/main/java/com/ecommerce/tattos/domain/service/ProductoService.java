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
    public Optional<Producto> getProduct(Long productoId) {
        return iProductoRepository.getProduct(productoId);
    }

    /**
     * Devuelve la lista de productos que pertenecen a una misma categoria
     * @param tipoProductoId Categoria de productos a retornar
     * @return Lista de productos con la categoria recibida por parametro
     */
    public Optional<List<Producto>> getByTipoProducto(Long tipoProductoId){
        return iProductoRepository.getByTipoProducto(tipoProductoId);
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
     * Actualiza un producto con los nuevos datos
     * @param productoId Id del producto
     * @return Producto actualizado
     */
    public boolean update(Long productoId, Producto productoNuevo){
        if(getProduct(productoId).isPresent()){
            getProduct(productoId).ifPresent(producto -> {
                producto.setNombre(productoNuevo.getNombre());
                producto.setPrecioVenta(productoNuevo.getPrecioVenta());
                producto.setCantidadStock(productoNuevo.getCantidadStock());
                save(producto);
            });
            return true;
        }
        return false;
    }

    /**
     * Elimina un producto dado su id
     * @param productoId Id del producto a borrar
     * @return True si se logra borrar, false si el producto no existe
     */
    public boolean delete(Long productoId){
        try {
            iProductoRepository.delete(productoId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
