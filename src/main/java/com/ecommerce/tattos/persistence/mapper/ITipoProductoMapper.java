package com.ecommerce.tattos.persistence.mapper;

import com.ecommerce.tattos.domain.TipoProducto;
import com.ecommerce.tattos.persistence.entity.TipoProductoEntidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper que convierte objetos de TipoProducto a dominio o entidades
 */
@Mapper(componentModel = "spring")
public interface ITipoProductoMapper {


    /**
     * Devuelve un tipo producto de dominio convertido de la entidad tipo producto
     * @param tipoProductoEntidad Entidad tipo producto
     * @return Tipo producto de dominio convertido de una entidad
     */
    //Recibe como fuente los datos de la entidad y los pasa a los de domino
    @Mapping(source = "idTipoProducto", target = "idTipoProducto")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "productos", target = "productos")
    TipoProducto toTipoProducto(TipoProductoEntidad tipoProductoEntidad);

    /**
     * Devuelve una entidad tipo producto convertido de un tipo producto de dominio
     * @param tipoProducto Tipo producto de dominio
     * @return Entidad tipo producto convertido de un objeto de dominio
     */
    //Se aplica la configuracion inversa de la otra conversion
    @InheritInverseConfiguration
    TipoProductoEntidad toTipoProductoEntidad(TipoProducto tipoProducto);
}
