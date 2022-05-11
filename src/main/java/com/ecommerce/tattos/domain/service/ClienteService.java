package com.ecommerce.tattos.domain.service;

import com.ecommerce.tattos.domain.Cliente;
import com.ecommerce.tattos.domain.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    /**
     * Interfaz que tiene las reglas del repositorio
     */
    private IClienteRepository iClienteRepository;

    /**
     * Construye un servicio Cliente
     * @param iClienteRepository Repositorio de cliente
     */
    @Autowired
    public ClienteService(IClienteRepository iClienteRepository) {
        this.iClienteRepository = iClienteRepository;
    }

    /**
     * Retorna todos los clientes
     * @return Lista con todos los clientes
     */
    public List<Cliente> getAll(){
        return iClienteRepository.getAll();
    }

    /**
     * Obtiene un cliente dado su id
     * @param clienteId Id del producto
     * @return El cliente con el id proporcionado
     */
    public Optional<Cliente> getCliente(String clienteId) {
        return iClienteRepository.getCliente(clienteId);
    }

    /**
     * Guarda un nuevo cliente
     * @param cliente Cliente nuevo
     * @return Cliente guardado
     */
    public Cliente save(Cliente cliente){
        return iClienteRepository.save(cliente);
    }

    /**
     * Borra un cliente dado su id
     * @param clienteId Id del cliente
     * @return True si se pudo borrar, false si el cliente no existe
     */
    public boolean delete(String clienteId){
        try {
            iClienteRepository.delete(clienteId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

}
