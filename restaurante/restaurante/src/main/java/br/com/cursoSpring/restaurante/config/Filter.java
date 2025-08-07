package br.com.cursoSpring.restaurante.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.cursoSpring.restaurante.usuario.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Filter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException{

       String token = buscarToken(request);
       if(token != null){
            String usuarioLogin = tokenService.buscarUsuarioToken(token);
            var usuario = userRepository.findByLogin(usuarioLogin);

            var autenticador = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autenticador);
       }

       filterChain.doFilter(request, response);
    }

    private String buscarToken(HttpServletRequest request){
        var authorization = request.getHeader("Authorization");
       
        if(authorization != null){
            return authorization.replace("Bearer ", "");
        }
        return null;
    }
}
