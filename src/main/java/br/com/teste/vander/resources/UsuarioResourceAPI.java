package br.com.teste.vander.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.vander.domain.UsuarioResponse;
import br.com.teste.vander.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/usuarios")
@AllArgsConstructor
public class UsuarioResourceAPI {

    private UsuarioService service;

    @ApiOperation(value =  "Busca por um código da API Externa do Usuário")
    @GetMapping
    public ResponseEntity<UsuarioResponse> consulta(){
        return ResponseEntity.ok(service.get());
    }
}
