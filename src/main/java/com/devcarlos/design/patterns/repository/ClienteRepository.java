package com.devcarlos.design.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devcarlos.design.patterns.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
