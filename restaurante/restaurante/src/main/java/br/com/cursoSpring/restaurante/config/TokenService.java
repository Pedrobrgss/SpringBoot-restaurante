package br.com.cursoSpring.restaurante.config;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {
    public String criarToken(){
        try {
            Algorithm algoritmo = Algorithm.HMAC256("1234");
            return JWT.create().withIssuer("Restaurante").sign(algoritmo);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao criar o Token", e);
        }
    }
}
