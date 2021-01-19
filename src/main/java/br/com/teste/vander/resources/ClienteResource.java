package br.com.teste.vander.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.vander.domain.Cliente;
import br.com.teste.vander.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public Cliente find(@PathVariable Integer id){
		 return service.find(id);
	}
	
	@GetMapping
	public List<Cliente> listar(){
		return service.findAll();
	}

}
