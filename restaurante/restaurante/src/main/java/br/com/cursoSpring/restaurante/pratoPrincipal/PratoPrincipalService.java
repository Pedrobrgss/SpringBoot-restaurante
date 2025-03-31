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

}
