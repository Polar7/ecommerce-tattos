package com.ecommerce.tattos.persistence.mapper;

import com.ecommerce.tattos.domain.Cliente;
import com.ecommerce.tattos.persistence.entity.ClienteEntidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que convierte objetos de Cliente a dominio o entidades
 */
@Mapper(componentModel = "spring", uses = {ICompraMapper.class})
public interface IClienteMapper {

    /**
     * Devuelve un Cliente de dominio convertido de la entidad Cliente
     * @param clienteEntidad Cliente entidad
     * @return Cliente de dominio convertido de una entidad
     */
    @Mapping(source = "idCliente", target = "idCliente")
    @Mapping(source = "nombreCompleto", target = "nombreCompleto")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "compras", target = "compras")
    Cliente toCliente(ClienteEntidad clienteEntidad);

    /**
     * Retorna una lista de clientes de dominio pasada una lista de clientes entidad
     * @param clienteEntidads de compras entidad
     * @return Retorna una lista de clientes de dominio
     */
    List<Cliente> toClientes(List<ClienteEntidad> clienteEntidads);

    /**
     * Devuelve una entidad Cliente convertido de un Cliente de dominio
     * @param cliente Cliente de dominio
     * @return Entidad Cliente convertido de un objeto de dominio
     */
    @InheritInverseConfiguration
    ClienteEntidad toClienteEntidad(Cliente cliente);
}
