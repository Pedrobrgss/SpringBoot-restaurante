package br.com.cursoSpring.restaurante.config;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.cursoSpring.restaurante.usuario.Usuario;

@Service
public class TokenService {
    public String criarToken(Usuario usuario){
        try {
            Algorithm algoritmo = Algorithm.HMAC256("1234");
            LocalDateTime dataExpiracao = LocalDateTime.now().plusHours(2);

            return JWT.create()
            .withIssuer("Restaurante")
            .withSubject(usuario.getLogin())
            .withExpiresAt(dataExpiracao.toInstant(ZoneOffset.of("-03:00")))
            .sign(algoritmo);

        } catch (JWTCreationException e) {

            throw new RuntimeException("Erro ao criar o Token", e);

        }
    }

    // método para validar o token 
    public String buscarUsuarioToken(String token){
        try {
             Algorithm algoritmo = Algorithm.HMAC256("1234");

             return JWT.require(algoritmo)
             .withIssuer("Restaurante")
             .build()
             .verify(token)
             .getSubject();

        } catch (JWTVerificationException e) {
           throw new RuntimeException("Token incorreto!");
        }
    }
}
