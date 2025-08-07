package br.com.cursoSpring.restaurante.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosUsuariosCadastro {
    private long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
