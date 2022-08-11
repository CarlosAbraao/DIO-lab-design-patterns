package com.devcarlos.design.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devcarlos.design.patterns.entities.Cliente;
import com.devcarlos.design.patterns.entities.Endereco;



@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
