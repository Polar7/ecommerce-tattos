package com.ecommerce.tattos.persistence.mapper;

import com.ecommerce.tattos.domain.ComprasProducto;
import com.ecommerce.tattos.persistence.entity.ComprasProductoEntidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICompraProductoMapper {

    /**
     * Retorna una CompraProducto de dominio convertido de la entidad CompraProducto
     * @param productoEntidad CompraProducto entidad
     * @return CompraProducto de dominio convertido de una entidad
     */
    @Mapping(source = "id.idProducto", target = "idProducto")
    @Mapping(source = "cantidad", target = "cantidad")
    @Mapping(source = "total", target = "total")
    ComprasProducto toCompraProducto(ComprasProductoEntidad productoEntidad);

    /**
     * Devuelve una entidad CompraProducto convertido de una ComprasProducto de dominio
     * @param comprasProducto CompraProducto de dominio
     * @return Entidad CompraProducto convertido de un objeto de dominio
     */
    @InheritInverseConfiguration
    @Mapping(target = "compraEntidad", ignore = true)
    @Mapping(target = "productoEntidad", ignore = true)
    @Mapping(target = "id.idCompra", ignore = true)
    ComprasProducto toComprasProducto(ComprasProducto comprasProducto);

}
