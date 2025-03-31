package br.com.cursoSpring.restaurante.pratoPrincipal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PratoPrincipalDTO {
    private String nome;
    private double preco;
    private boolean disponivel;
    private Sabor sabor;
    private Tamanho tamanho;
}
