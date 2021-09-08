package com.capgemini.market.persistence.crud;

import com.capgemini.market.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Integer> {
}
