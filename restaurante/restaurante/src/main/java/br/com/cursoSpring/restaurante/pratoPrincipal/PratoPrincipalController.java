package br.com.cursoSpring.restaurante.pratoPrincipal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PratoPrincipalDTO> cadastrar(@RequestBody @Valid PratoPrincipalDTO dto, UriComponentsBuilder uriBuilder) {
        PratoPrincipalDTO pratoPrincipalDTO = pratoPrincipalService.criarPratoPrincipal(dto); 

        URI endereco = uriBuilder.path("/pratosprincipais/{id}").buildAndExpand(pratoPrincipalDTO.getId()).toUri();

        return ResponseEntity.created(endereco).body(pratoPrincipalDTO);
    }

    @GetMapping
    public ResponseEntity<Page<PratoPrincipalDTO>> buscarTodos(@PageableDefault(size = 10) Pageable paginacao) {
        Page<PratoPrincipalDTO> page = pratoPrincipalService.buscarTodos(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PratoPrincipalDTO> buscarPorID(@PathVariable @NotNull long id) {

        PratoPrincipalDTO pratoPrincipalDTO = pratoPrincipalService.buscarPorID(id);

        return ResponseEntity.ok(pratoPrincipalDTO);
    }
    
    @PutMapping("{id}")
        public ResponseEntity<PratoPrincipalDTO> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PratoPrincipalDTO dto ){
            PratoPrincipalDTO pratoAtualizado = pratoPrincipalService.atualizarPrato(id, dto);
            return ResponseEntity.ok(pratoAtualizado);
        }

    @DeleteMapping("{id}")
        public ResponseEntity<PratoPrincipalDTO> deletar(@PathVariable @NotNull Long id){
            pratoPrincipalService.deletar(id);
            return ResponseEntity.noContent().build();
        }
}
