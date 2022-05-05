package com.ecommerce.tattos.persistence;

import com.ecommerce.tattos.domain.Compra;
import com.ecommerce.tattos.domain.repository.ICompraRepository;
import com.ecommerce.tattos.persistence.crud.ICompraCrudRepository;
import com.ecommerce.tattos.persistence.entity.CompraEntidad;
import com.ecommerce.tattos.persistence.mapper.ICompraMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de compra encargado de implementar las reglas descritas por el dominio.
 * Y ejecutar las operaciones en la base de datos
 */
@Getter @Setter
@Repository
public class CompraRepository implements ICompraRepository {

    /**
     * Interfaz que extendiende los metodos relacionados a la base de datos
     */
    private ICompraCrudRepository compraCrudRepository;

    /**
     * Mapper para la conversion de objetos de dominio y entidad
     */
    private ICompraMapper mapper;

    /**
     * Construye un repositorio de compra inyectando los objetos
     * @param compraCrudRepository RepositorioCrud con los metodos a la db
     * @param mapper Mapper de compra
     */
    @Autowired
    public CompraRepository(ICompraCrudRepository compraCrudRepository, ICompraMapper mapper) {
        this.compraCrudRepository = compraCrudRepository;
        this.mapper = mapper;
    }

    /**
     * Devuelve la lista de compras de dominio obtenida por el CRUD
     * @return Toda la lista de compras en terminos de dominio
     */
    @Override
    public List<Compra> getAll() {
        return mapper.toCompras((List<CompraEntidad>) compraCrudRepository.findAll());
    }

    /**
     * Devuele la lista de compras hecha por un cliente dado su id
     * @param clientId Id del cliente
     * @return Lista de compras hechas por un cliente
     */
    @Override
    public Optional<List<Compra>> getByCliente(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).
                map(compra -> mapper.toCompras(compra));
    }

    /**
     * Guarda una nueva compra
     * @param compra Compra nueva
     * @return La compra guardada
     */
    @Override
    public Compra save(Compra compra) {
        CompraEntidad compraEntidad = mapper.toCompraEntidad(compra);

        compraEntidad.getProductos().forEach(producto -> producto.setCompraEntidad(compraEntidad));

        return mapper.toCompra(compraCrudRepository.save(compraEntidad));
    }
}
