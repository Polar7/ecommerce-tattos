package com.ecommerce.tattos.persistence.crud;

import com.ecommerce.tattos.persistence.entity.ClienteEntidad;
import org.springframework.data.repository.CrudRepository;

public interface IClienteCrudRepository extends CrudRepository<ClienteEntidad, String> {
}
