package br.com.cursoSpring.restaurante.pratoPrincipal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/pratosprincipais") // Define o endpoint base para as requisições
@RequiredArgsConstructor // Gera automaticamente um construtor com os atributos `final`
public class PratoPrincipalController {

    private final PratoPrincipalService pratoPrincipalService; // Injeta o serviço responsável pela lógica de negócios

    @PostMapping // Mapeia a requisição HTTP POST para este método
    public void cadastrar(@RequestBody @Valid PratoPrincipalDTO dto) {
        pratoPrincipalService.criarPratoPrincipal(dto); // Chama o serviço para cadastrar o prato principal
    }

    @GetMapping
    public Page<PratoPrincipalDTO> buscarTodos(@PageableDefault(size = 10) Pageable paginacao) {
        return pratoPrincipalService.buscarTodos(paginacao);
    }

    @GetMapping("/{id}")
    public PratoPrincipalDTO buscarPorID(@PathVariable @NotNull long id) {

        return pratoPrincipalService.buscarPorID(id);
    }
    
    @PutMapping("{id}")
        public PratoPrincipalDTO atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PratoPrincipalDTO dto ){
            PratoPrincipalDTO pratoAtualizado = pratoPrincipalService.atualizarPrato(id, dto);
            return pratoAtualizado;
        }

    @DeleteMapping("{id}")
        public void deletar(@PathVariable @NotNull Long id){
            pratoPrincipalService.deletar(id);
        }
}
