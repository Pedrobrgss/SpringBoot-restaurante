package br.com.cursoSpring.restaurante.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Informa para o Spring o tipo da classe "Configuration"
@Configuration
public class Configurations {

     // Define um bean gerenciado pelo Spring, permitindo a injeção do ModelMapper em outras partes do projeto
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
