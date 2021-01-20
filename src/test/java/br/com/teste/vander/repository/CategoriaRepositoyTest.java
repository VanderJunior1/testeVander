package br.com.teste.vander.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.teste.vander.domain.Categoria;
import br.com.teste.vander.respositories.CategoriaRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CategoriaRepositoyTest {
	
	//Exemplos de teste com Junit
	
	@Autowired
	private CategoriaRepository repo;

	
	@Test
	@Order(1)
	public void saveTest() {
		Categoria categoria = new Categoria(null, "Categoria Teste");
		Categoria createCategoria  = repo.save(categoria);
		
		assertThat(createCategoria.getNome()).isEqualTo( "Categoria Teste");
	}
	
	@Test
	@Order(2)
	public void updateTest() {
		Optional<Categoria> getCategoria  = repo.findById(1);
		Categoria result = getCategoria.get();
		assertThat(result.getId()).isEqualTo(1);
		
		result.setNome("Categoria Testada");
		
		Categoria categoriaAlterada = repo.save(result);
		assertThat(categoriaAlterada.getNome()).isEqualTo( "Categoria Testada");
	}
	
	@Test
	@Order(3)
	public void getByIdTest() {
		Optional<Categoria> catOptional = repo.findById(1);
		Categoria result = catOptional.get();
		assertThat(result.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(4)
	public void listTest() {
		List<Categoria> lista = repo.findAll();
		assertThat(lista.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(5)
	public void deleteTest() {
		repo.deleteById(3);
		Optional<Categoria> catOptional = repo.findById(3);
		assertThat(catOptional.isEmpty());
	}


}
