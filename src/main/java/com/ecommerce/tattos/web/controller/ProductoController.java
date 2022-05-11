package com.ecommerce.tattos.web.controller;

import com.ecommerce.tattos.domain.Producto;
import com.ecommerce.tattos.domain.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que actua como un controlador tipo Rest para los productos
 */
@CrossOrigin
@RestController
@RequestMapping("/productos")
public class ProductoController {

    /**
     * Servicio de compra con la logica de negocio
     */
    private ProductoService productoService;

    /**
     * Construye un nuevo controlador de Compra
     *
     * @param productoService Servicio de Compra
     */
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Devuelve un ResponseEntity con la lista de productos
     * @return ResponseEntity con la lista de productos y ok http 200
     */
    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        return new ResponseEntity<>(productoService.getAll(), HttpStatus.OK);
    }

    /**
     * Devuelve un producto dado su id
     * @param productoId Id del producto
     * @return Un producto dado su Id y Http 200 si encuentra al producto, 404 de lo contrario
     */
    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> getProduct(@PathVariable("productoId") Long productoId) {
        //El metodo .of nos acorta la respuesta de Ok o Not_found
        return ResponseEntity.of(productoService.getProduct(productoId));
    }

    /**
     * Devuelve la lista de productos con el id dado por parametro
     * @param tipoProductoId Id del TipoProducto
     * @return Lista de productos con un id, Http 200 si encuentra productos, 404 de lo contrario
     */
    @GetMapping("/tipos-productos/{tipoProductoId}")
    public ResponseEntity<List<Producto>> getByCategory(@PathVariable("tipoProductoId") Long tipoProductoId){
        return ResponseEntity.of(productoService.getByTipoProducto(tipoProductoId));
    }

    /**
     * Guarda un nuevo producto
     * @param producto Producto nuevo
     * @return EL producto guardado y http 201 creado
     */
    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    /**
     * Actualiza un producto con nueva informacion
     * @param productoId Id del producto
     * @param producto Producto con la informacion nueva
     * @return
     */
    @PatchMapping("/{productoId}")
    public ResponseEntity update(@PathVariable("productoId") Long productoId, @RequestBody Producto producto){
        return new ResponseEntity(this.productoService.update(productoId, producto)
                ? HttpStatus.OK
                : HttpStatus.NOT_FOUND);
    }

    /**
     * Elimina un producto dado su Id
     * @param productoId Id del producto
     * @return Http 200 si se borró correctamente, 404 si no existe un producto con el id
     */
    @DeleteMapping("/{productoId}")
    public ResponseEntity delete(@PathVariable("productoId") Long productoId){
        return new ResponseEntity(this.productoService.delete(productoId)
                ? HttpStatus.OK
                : HttpStatus.NOT_FOUND);
    }
}
