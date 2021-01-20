package br.com.teste.vander.services;

import org.springframework.stereotype.Service;

import br.com.teste.vander.client.UsuarioClient;
import br.com.teste.vander.domain.UsuarioResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioClient client;

    public UsuarioResponse get(){
        return client.getAleatorioResponse(1);
    }

}
