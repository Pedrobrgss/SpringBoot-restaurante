package br.com.cursoSpring.restaurante.infraestrutura;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorExceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> trataException404(){
        return ResponseEntity.notFound().build();
    }
}
