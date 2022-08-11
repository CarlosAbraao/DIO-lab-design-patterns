package com.devcarlos.design.patterns.repository;

import org.springframework.data.repository.CrudRepository;

import com.devcarlos.design.patterns.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
