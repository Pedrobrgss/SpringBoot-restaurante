package br.com.cursoSpring.restaurante.pratoPrincipal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PratoPrincipalDTO {
    @NotBlank
    private String nome;
    @Positive
    private double preco;
    private boolean disponivel;
    private Sabor sabor;
    private Tamanho tamanho;
    private Servico servico;
}
