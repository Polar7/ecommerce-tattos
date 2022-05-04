package com.ecommerce.tattos.persistence.mapper;

import com.ecommerce.tattos.domain.Compra;
import com.ecommerce.tattos.persistence.entity.CompraEntidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que convierte objetos de Compra a dominio o entidades
 */
@Mapper(componentModel = "spring", uses = {ICompraProductoMapper.class})
public interface ICompraMapper {

    /**
     * Devuelve una Compra de dominio convertido de la entidad Compra
     * @param compraEntidad Compra entidad
     * @return Compra de dominio convertido de una entidad
     */
    @Mapping(source = "idCompra", target = "idCompra")
    @Mapping(source = "idCliente", target = "idCliente")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "medioPago", target = "medioPago")
    @Mapping(source = "productos", target = "comprasProducto")
    Compra toCompra(CompraEntidad compraEntidad);

    /**
     * Retorna una lista de compras de dominio pasada una lista de compras entidad
     * @param comprasEntidad Lista de compras entidad
     * @return Retorna una lista de compras de dominio
     */
    List<Compra> toCompras(List<CompraEntidad> comprasEntidad);

    /**
     * Devuelve una entidad Compra convertido de una Compra de dominio
     * @param compra Compra de dominio
     * @return Entidad Compra convertido de un objeto de dominio
     */
    @InheritInverseConfiguration
    @Mapping(target = "clienteEntidad", ignore = true)
    CompraEntidad toCompraEntidad(Compra compra);
}
