package br.com.teste.vander.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.teste.vander.domain.Categoria;
import br.com.teste.vander.domain.Cidade;
import br.com.teste.vander.domain.Cliente;
import br.com.teste.vander.domain.Endereco;
import br.com.teste.vander.domain.Estado;
import br.com.teste.vander.domain.ItemPedido;
import br.com.teste.vander.domain.Pagamento;
import br.com.teste.vander.domain.PagamentoComBoleto;
import br.com.teste.vander.domain.PagamentoComCartao;
import br.com.teste.vander.domain.Pedido;
import br.com.teste.vander.domain.Produto;
import br.com.teste.vander.domain.enums.EstadoPagamento;
import br.com.teste.vander.domain.enums.TipoCliente;
import br.com.teste.vander.respositories.CategoriaRepository;
import br.com.teste.vander.respositories.CidadeRepository;
import br.com.teste.vander.respositories.ClienteRepository;
import br.com.teste.vander.respositories.EnderecoRepository;
import br.com.teste.vander.respositories.EstadoRepository;
import br.com.teste.vander.respositories.ItemPedidoRepository;
import br.com.teste.vander.respositories.PagamentoRepository;
import br.com.teste.vander.respositories.PedidoRepository;
import br.com.teste.vander.respositories.ProdutoRepository;


@Configuration
public class Initialization implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cateRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private EnderecoRepository endRepo;
	@Autowired
	private PedidoRepository pedRepo;
	@Autowired
	private PagamentoRepository pgtoRepo;
	@Autowired
	private ItemPedidoRepository itemPedidoRepo;

	@Override
	public void run(String... args) throws Exception {

		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", BigDecimal.valueOf(2000.00));
		Produto p2 = new Produto(null, "Impressora", BigDecimal.valueOf(800.00));
		Produto p3 = new Produto(null, "Mouse", BigDecimal.valueOf(80.00));

		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		cateRepo.saveAll(Arrays.asList(c1, c2));
		prodRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "são Paulo");
		
		Cidade cidade = new Cidade(null ,"Uberlândia", est1);
		Cidade cidade2 = new Cidade(null ,"São Paulo", est2);
		Cidade cidade3 = new Cidade(null ,"campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cidade));
		est2.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		
		estadoRepo.saveAll(Arrays.asList(est1,est2));
		cidadeRepo.saveAll(Arrays.asList(cidade,cidade2,cidade3));
		
		Cliente cli1 = new Cliente(null, "maria", "maria@hotmail.com", "cpf0999890", TipoCliente.PESSOAFISICA, "123456");
		cli1.getTelefones().addAll(Arrays.asList("3232-3232", "9999-99999"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apt 303", "jardim", "38400000", cli1, cidade);
		Endereco e2 = new Endereco(null, "Rua Cravos", "105", "Sala 3", "Centro", "38400000", cli1, cidade2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		cliRepo.saveAll(Arrays.asList(cli1));
		endRepo.saveAll(Arrays.asList(e1,e2));
		
		Pedido ped1 = new Pedido(null, LocalDateTime.of(2017, 9, 30, 10, 32), cli1, e1);
		Pedido ped2 = new Pedido(null, LocalDateTime.of(2017, 10, 10, 19, 35), cli1, e2);
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, LocalDateTime.of(2017, 9, 10, 0, 0), null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedRepo.saveAll(Arrays.asList(ped1,ped2));
		pgtoRepo.saveAll(Arrays.asList(pgto1,pgto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepo.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}

}
