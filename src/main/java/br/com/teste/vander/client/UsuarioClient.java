package br.com.teste.vander.client;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.teste.vander.domain.UsuarioResponse;

@Component
public class UsuarioClient {

    public UsuarioResponse getAleatorioResponse(Integer id){
    	RestTemplate restTemplate = new RestTemplate();
        String url = "https://6006f99f3698a80017de267e.mockapi.io/api/vi/Usuarios/" + id;
        return restTemplate.getForEntity(url, UsuarioResponse.class).getBody();
    }
}
