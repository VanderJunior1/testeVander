package br.com.teste.vander.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UsuarioResponse {

	@EqualsAndHashCode.Include
	private Integer id;
	private String nome;
	private String email;
	private Boolean ativo;
}
