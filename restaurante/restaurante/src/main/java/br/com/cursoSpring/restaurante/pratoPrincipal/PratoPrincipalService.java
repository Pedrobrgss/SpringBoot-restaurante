package br.com.cursoSpring.restaurante.pratoPrincipal;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
