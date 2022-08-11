package com.devcarlos.design.patterns.repository;

import org.springframework.data.repository.CrudRepository;

import com.devcarlos.design.patterns.entities.Cliente;
import com.devcarlos.design.patterns.entities.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
