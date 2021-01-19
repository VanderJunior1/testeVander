package br.com.teste.vander.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.teste.vander.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, LocalDateTime instanteDoPedido) {
		pagto.setDataVencimento(LocalDateTime.now());
	}
}
