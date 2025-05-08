package br.com.cursoSpring.restaurante.pratoPrincipal;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
//cria o construtor dos atributos que são requisitados
@RequiredArgsConstructor
public class PratoPrincipalService {

    private final PratoPrincipalRepository pratoPrincipalRepository;
    private final ModelMapper modelMapper;


    public PratoPrincipalDTO criarPratoPrincipal(PratoPrincipalDTO dto) {
        // Converte o DTO recebido para a entidade PratoPrincipal
        PratoPrincipal pratoPrincipal = modelMapper.map(dto, PratoPrincipal.class);

        // Salva a entidade no banco de dados
        pratoPrincipalRepository.save(pratoPrincipal);

        // Converte a entidade salva de volta para DTO e retorna
        return modelMapper.map(pratoPrincipal, PratoPrincipalDTO.class);
    }

    public Page<PratoPrincipalDTO> buscarTodos(Pageable paginacao){
        return pratoPrincipalRepository
                .findAll(paginacao)
                .map(p->modelMapper.map(p, PratoPrincipalDTO.class)); // Busca todos os pratos principais do banco
    
    }

    public PratoPrincipalDTO buscarPorID(long id){
        PratoPrincipal pratoPrincipal = pratoPrincipalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pratoPrincipal, PratoPrincipalDTO.class);
    }

    public PratoPrincipalDTO atualizarPrato(Long id, PratoPrincipalDTO dto){
        PratoPrincipal prato = modelMapper.map(dto, PratoPrincipal.class);
        prato.setId(id);
        prato = pratoPrincipalRepository.save(prato);
        return modelMapper.map(prato, PratoPrincipalDTO.class);
    }

    public void deletar(Long id){
        pratoPrincipalRepository.deleteById(id);
    }
}