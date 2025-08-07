package br.com.cursoSpring.restaurante.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriptografiaSenha {

    private final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String criptografia(String senha){
        return encoder.encode(senha);
    }
}
