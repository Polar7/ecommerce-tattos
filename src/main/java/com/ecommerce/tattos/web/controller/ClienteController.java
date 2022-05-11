package com.ecommerce.tattos.web.controller;

import com.ecommerce.tattos.domain.Cliente;
import com.ecommerce.tattos.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que actua como un controlador tipo Rest para los clientes
 */
@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    /**
     * Servicio de cliente con la logica de negocio
     */
    private ClienteService clienteService;

    /**
     * Construye un nuevo controlador de Cliente
     * @param clienteService Servicio de Cliente
     */
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Devuelve la lista de clientes
     * @return ResponseEntity con la lista de clientes y ok http 200
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
    }

    /**
     *  Devuelve un cliente dado su id
     * @param clienteId Id del cliente
     * @return Un cliente dado su Id y Http 200 si encuentra al cliente, 404 de lo contrario
     */
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("clienteId") String clienteId) {
        return ResponseEntity.of(clienteService.getCliente(clienteId));
    }

    /**
     * Guarda un nuevo cliente
     * @param cliente Cliente nuevo
     * @return EL cliente guardado y http 201 creado
     */
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    /**
     * Elimina un cliente dado su Id
     * @param clienteId Id del cliente
     * @return Http 200 si se borró correctamente, 404 si no existe un cliente con el id
     */
    @DeleteMapping("/{clienteId}")
    public ResponseEntity delete(@PathVariable("clienteId") String clienteId){
        return new ResponseEntity(this.clienteService.delete(clienteId)
                ? HttpStatus.OK
                : HttpStatus.NOT_FOUND);
    }
}
