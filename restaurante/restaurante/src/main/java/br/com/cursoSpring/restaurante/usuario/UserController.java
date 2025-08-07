package br.com.cursoSpring.restaurante.usuario;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<DadosUsuariosCadastro>cadastrar(@RequestBody @Valid DadosUsuariosCadastro dto, UriComponentsBuilder uBuilder){
        DadosUsuariosCadastro dadosUsuariosCadastro = userService.cadastrarUsuario(dto);

        URI endereco = uBuilder.path("/usuarios/{id}").buildAndExpand(dadosUsuariosCadastro.getId()).toUri();

        return ResponseEntity.created(endereco).body(dadosUsuariosCadastro);
    }
}
