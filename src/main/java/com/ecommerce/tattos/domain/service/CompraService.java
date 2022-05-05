package com.ecommerce.tattos.domain.service;

import com.ecommerce.tattos.domain.Compra;
import com.ecommerce.tattos.domain.repository.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    //Al llamar la interfaz, lo que se inyecta verdaderamente es la implementacion CompraRepository
    /**
     * Interfaz que tiene las reglas del repositorio
     */
    private ICompraRepository iCompraRepository;

    @Autowired
    public CompraService(ICompraRepository iCompraRepository) {
        this.iCompraRepository = iCompraRepository;
    }

    /**
     * Devuelve todas las compras realizadas
     * @return Todas las compras
     */
    public List<Compra> getAll() {
        return iCompraRepository.getAll();
    }

    /**
     * Devuelve todas las compras hechas por determinado cliente
     * @param clienteId Id del cliente
     * @return Las compras hechas por un cliente dado su id
     */
    public Optional<List<Compra>> getByCliente(String clienteId) {
        return iCompraRepository.getByCliente(clienteId);
    }

    /**
     * Crea una nueva compra
     * @param compra Compra a crear
     * @return La compra creada
     */
    public Compra save(Compra compra) {
        return iCompraRepository.save(compra);
    }
}
