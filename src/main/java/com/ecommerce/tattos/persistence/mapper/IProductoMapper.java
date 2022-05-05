package com.ecommerce.tattos.persistence.mapper;

import com.ecommerce.tattos.domain.Producto;
import com.ecommerce.tattos.persistence.entity.ProductoEntidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que convierte objetos de Producto a dominio o entidades
 */
@Mapper(componentModel = "spring")
public interface IProductoMapper {

    /**
     * Devuelve un Producto de dominio convertido de la entidad Producto
     * @param producto Entidad Producto
     * @return Producto de dominio convertido de una entidad
     */
    @Mapping(source = "idProducto", target = "idProducto")
    @Mapping(source = "idTipoProducto", target = "idTipoProducto")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "precioVenta", target = "precioVenta")
    @Mapping(source = "cantidadStock", target = "cantidadStock")
    @Mapping(source = "urlImagen", target = "urlImagen")
    Producto toProducto(ProductoEntidad producto);

    /**
     * Retorna una lista de productos de dominio pasada una lista de productos entidad
     * @param productosEntidad Lista de productos entidad
     * @return Retorna una lista de productos de dominio
     */
    List<Producto> toProductos(List<ProductoEntidad> productosEntidad);

    /**
     * Devuelve una entidad Producto convertido de un Producto de dominio
     * @param producto Producto de dominio
     * @return Entidad Producto convertido de un objeto de dominio
     */
    @InheritInverseConfiguration
    @Mapping(target = "tipoProductoEntidad", ignore = true)
    @Mapping(target = "compras", ignore = true)
    ProductoEntidad toProductoEntidad(Producto producto);
}
