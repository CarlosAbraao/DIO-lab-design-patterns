package com.devcarlos.design.patterns.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devcarlos.design.patterns.entities.Endereco;

@FeignClient(name = "viacep" , url = "https://viacep.com.br/ws")
public interface ViaCepClientService {
	
	
	
	@GetMapping("/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") String cep);
	
	
	
	

}
