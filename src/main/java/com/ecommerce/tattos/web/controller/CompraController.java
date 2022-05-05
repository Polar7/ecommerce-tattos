package com.ecommerce.tattos.web.controller;

import com.ecommerce.tattos.domain.Compra;
import com.ecommerce.tattos.domain.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

/**
 * Clase que actua como un controlador tipo Rest para las compras
 */
@RestController
@RequestMapping("/compras")
public class CompraController {

    /**
     * Servicio de compra con la logica de negocio
     */
    private CompraService compraService;

    /**
     * Construye un nuevo controlador de Compra
     * @param compraService Servicio de Compra
     */
    @Autowired
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    /**
     * Devuelve un ResponseEntity con la lista de compras
     * @return ResponseEntity con la lista de compras y ok http 200
     */
    @GetMapping
    public ResponseEntity<List<Compra>> getAll()
    {
        return new ResponseEntity<>(compraService.getAll(), HttpStatus.OK);
    }

    /**
     * Devuelve un ResponseEntity con la lista de compras hechas por un cliente dado su id
     * @param clienteId Id del cliente
     * @return Lista de compras de un cliente y Http 200 si encuentra a un cliente, 404 si no lo encuentra
     */
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<List<Compra>> getByCliente(@PathVariable("clienteId") String clienteId){
        //El metodo .of nos acorta la respuesta de Ok o Not_found
        return ResponseEntity.of(compraService.getByCliente(clienteId));
    }

    /**
     * Guarda una nueva compra y devuelve su ResponseEntity
     * @param compra Compra nueva
     * @return La compra guardada y 201 http creado
     */
    @PostMapping()
    public ResponseEntity<Compra> save(@RequestBody Compra compra){
        return new ResponseEntity<>(compraService.save(compra), HttpStatus.CREATED);
    }

}
