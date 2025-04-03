package br.com.cursoSpring.restaurante.pratoPrincipal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/pratosprincipais") // Define o endpoint base para as requisições
@RequiredArgsConstructor // Gera automaticamente um construtor com os atributos `final`
public class PratoPrincipalController {

    private final PratoPrincipalService pratoPrincipalService; // Injeta o serviço responsável pela lógica de negócios

    @PostMapping // Mapeia a requisição HTTP POST para este método
    public void cadastrar(@RequestBody PratoPrincipalDTO dto) {
        pratoPrincipalService.criarPratoPrincipal(dto); // Chama o serviço para cadastrar o prato principal
    }

}
