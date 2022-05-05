package com.ecommerce.tattos.persistence;

import com.ecommerce.tattos.domain.Producto;
import com.ecommerce.tattos.domain.repository.IProductoRepository;
import com.ecommerce.tattos.persistence.crud.IProductoCrudRepository;
import com.ecommerce.tattos.persistence.entity.ProductoEntidad;
import com.ecommerce.tattos.persistence.mapper.IProductoMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de Producto encargado de implementar las reglas descritas por el dominio.
 * Y ejecutar las operaciones en la base de datos
 */
@Getter @Setter
@Repository
public class ProductoRepository implements IProductoRepository {

    /**
     * Interfaz que extendiende los metodos relacionados a la base de datos
     */
    private IProductoCrudRepository iProductoCrudRepository;

    /**
     * Mapper para la conversion de objetos de dominio y entidad
     */
    private IProductoMapper mapper;

    /**
     * Construye un repositorio de producto inyectando los objetos
     * @param iProductoCrudRepository RepositorioCrud con los metodos a la db
     * @param mapper Mapper de producto
     */
    public ProductoRepository(IProductoCrudRepository iProductoCrudRepository, IProductoMapper mapper) {
        this.iProductoCrudRepository = iProductoCrudRepository;
        this.mapper = mapper;
    }

    /**
     * Devuelve la lista de productos de dominio obtenida por el CRUD
     * @return Toda la lista de productos en terminos de dominio
     */
    @Override
    public List<Producto> getAll() {
         return mapper.toProductos((List<ProductoEntidad>) iProductoCrudRepository.findAll());
    }

    /**
     * Obtiene un producto dado su Id
     * @param productoId Id del producto
     * @return Un optional producto dado su id
     */
    @Override
    public Optional<Producto> getProduct(Long productoId) {
        return iProductoCrudRepository.findById(productoId).map(producto -> mapper.toProducto(producto));
    }

    /**
     * Retorna una lista optional de productos ordenada por nombre dado su id de categoria
     * @param categoriaId Categoria de productos
     * @return Lista de productos con la categoria dada
     */
    @Override
    public Optional<List<Producto>> getByCategory(Long categoriaId) {
        List<ProductoEntidad> productosEntidad = iProductoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoriaId);
        return Optional.of(mapper.toProductos(productosEntidad));
    }

    /**
     * Guarda un nuevo producto
     * @param producto Producto a crear
     * @return Producto nuevo guardado
     */
    @Override
    public Producto save(Producto producto) {
        ProductoEntidad productoEntidad = mapper.toProductoEntidad(producto);
        return mapper.toProducto(iProductoCrudRepository.save(productoEntidad));
    }

    /**
     * Borra un producto dado su ID
     * @param productoId Id del producto a borrar
     */
    @Override
    public void delete(Long productoId) {
        iProductoCrudRepository.deleteById(productoId);
    }
}
