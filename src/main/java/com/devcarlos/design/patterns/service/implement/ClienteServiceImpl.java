package com.devcarlos.design.patterns.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdev.patterns.model.Cliente;
import com.carlosdev.patterns.model.Endereco;
import com.carlosdev.patterns.repository.ClienteRepository;
import com.carlosdev.patterns.repository.EnderecoRepository;
import com.carlosdev.patterns.service.ClienteService;
import com.carlosdev.patterns.service.ViaCepClientService;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepClientService viaCepClientService;
	
	

	@Override
	public Iterable<Cliente> buscarTodos() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
	  Optional<Cliente> cliente	= clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		 salvarClienteComCep(cliente);
		
		
		
		
		
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// buscar cliente por id caso n exista
		
		Optional<Cliente> clientebd	= clienteRepository.findById(id);
		if (clientebd.isPresent()) {
			
			salvarClienteComCep(cliente);
			
		}
		
		
		
	}
	
	
	
	private void salvarClienteComCep(Cliente cliente) {
		// FIXME verificar se o endereço do cliente ja existe (pelo cep)
				String cep = cliente.getEndereco().getCep();
				
				Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
					// FIXME caso não exista, integrar com o via cep e persistir o retorno.
					
					Endereco novoEndereco = viaCepClientService.consultarCep(cep);
					enderecoRepository.save(novoEndereco);
					return novoEndereco;
				});
				
				cliente.setEndereco(endereco);
				
				// FIXME inserir um novo cliente ( ou existente )
				clienteRepository.save(cliente);
	}
	

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
