package br.com.teste.vander.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.teste.vander.client.UsuarioClient;
import br.com.teste.vander.domain.UsuarioResponse;
import br.com.teste.vander.services.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class AleatorioServiceTest {

    @InjectMocks
    UsuarioService serviceMock;

    @Mock
    UsuarioClient clientMock;

    @Test
    public void testaQueOServicoRetornaOIdEsperado(){
    	UsuarioResponse usuario = new UsuarioResponse();
    	usuario.setId(1);

        when(clientMock.getAleatorioResponse(1)).thenReturn(usuario);
        assertEquals(clientMock.getAleatorioResponse(1), usuario);
    }

}
