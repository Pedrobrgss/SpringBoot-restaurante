package br.com.cursoSpring.restaurante.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager autenticador;

    @PostMapping
    public ResponseEntity<Void> validacaoCredenciaisUsuarios(@RequestBody @Valid CredenciaisUsuariosDTO credenciais){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credenciais.getLogin(), credenciais.getSenha());
        Authentication autenticacao = autenticador.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
