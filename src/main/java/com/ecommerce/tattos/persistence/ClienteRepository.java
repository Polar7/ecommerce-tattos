package com.ecommerce.tattos.persistence;

import com.ecommerce.tattos.domain.Cliente;
import com.ecommerce.tattos.domain.repository.IClienteRepository;
import com.ecommerce.tattos.persistence.crud.IClienteCrudRepository;
import com.ecommerce.tattos.persistence.entity.ClienteEntidad;
import com.ecommerce.tattos.persistence.mapper.IClienteMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de cliente encargado de implementar las reglas descritas por el dominio.
 * Y ejecutar las operaciones en la base de datos
 */
@Getter @Setter
@Repository
public class ClienteRepository implements IClienteRepository {

    /**
     * Interfaz que extendiende los metodos relacionados a la base de datos
     */
    private IClienteCrudRepository iClienteCrudRepository;

    /**
     * Mapper para la conversion de objetos de dominio y entidad
     */
    private IClienteMapper iClienteMapper;

    /**
     * Construye un repositorio de compra inyectando los objetos
     * @param iClienteCrudRepository RepositorioCrud con los metodos a la db
     * @param iClienteMapper Mapper de cliente
     */
    @Autowired
    public ClienteRepository(IClienteCrudRepository iClienteCrudRepository, IClienteMapper iClienteMapper) {
        this.iClienteCrudRepository = iClienteCrudRepository;
        this.iClienteMapper = iClienteMapper;
    }

    /**
     * Devuelve la lista de clientes de dominio obtenida por el CRUD
     * @return Toda la lista de clientes en terminos de dominio
     */
    @Override
    public List<Cliente> getAll() {
        return iClienteMapper.toClientes((List<ClienteEntidad>) iClienteCrudRepository.findAll());
    }

    /**
     * Obtiene un cliente dado su id
     * @param clienteId Id del cliente
     * @return Un optional cliente encontrado
     */
    @Override
    public Optional<Cliente> getCliente(String clienteId) {
        return iClienteCrudRepository.findById(clienteId).map(clienteEntidad -> iClienteMapper.toCliente(clienteEntidad));
    }

    /**
     * Guarda un nuevo cliente
     * @param cliente Cliente a guardar
     * @return Cliente nuevo guardado
     */
    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntidad clienteEntidad = iClienteMapper.toClienteEntidad(cliente);
        return iClienteMapper.toCliente(iClienteCrudRepository.save(clienteEntidad));
    }

    /**
     * Borra un cliente dado su ID
     * @param clienteId Id del cliente a borrar
     */
    @Override
    public void delete(String clienteId) {
        iClienteCrudRepository.deleteById(clienteId);
    }
}
