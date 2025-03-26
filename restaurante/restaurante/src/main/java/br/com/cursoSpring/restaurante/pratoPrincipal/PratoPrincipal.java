package br.com.cursoSpring.restaurante.pratoPrincipal;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// JPA (Java Persistence API): serve para mapear classes de entidade em tabelas de um banco de dados relacional (SQL).
@Entity // Informa para o Jpa que essa classe é uma entidade
@Table(name = "PratoPrincipal") // Informa o nome da tabela
//Lombok: biblioteca que reduz o boilerplate code (código repetitivo) em Java, gerando automaticamente getters, setters, construtores, toString(), equals(), e hashCode().
@Getter //Gera automaticamente os métodos get para todos os atributos da classe.
@Setter //Gera automaticamente os métodos set para todos os atributos da classe.    
@AllArgsConstructor //Gera automaticamente um construtor com todos os atributos como parâmetros
@NoArgsConstructor //Gera automaticamente um construtor vazio (sem argumentos).
@EqualsAndHashCode //Gera automaticamente os métodos equals() e hashCode() com base nos atributos da classe.
public class PratoPrincipal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private double preco;
    private boolean disponivel;
    @Enumerated(EnumType.STRING)
    private Sabor sabor;
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
}
