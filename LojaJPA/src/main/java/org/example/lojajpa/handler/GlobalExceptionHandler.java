package org.example.lojajpa.handler;
//Classe dedicada ao tratamentos de exceção global, a classe handler serve para dizer como vc vai manusear os erros


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //Basicamente um vigilante que atua quando executamos o código, se ocorrer uma exceção ele vai interceptá-lo e fazer o tratamento do erro
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> tratarValidacao(MethodArgumentNotValidException exception){
        Map<String, String> erros = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(erro ->
                erros.put(erro.getField(), erro.getDefaultMessage()));
        return erros;
    }//Parabéns, vc fez um tratamento de exceção para a validação dos dados (apenas saiba que isso existe)

    @ExceptionHandler(RuntimeException.class) //Erro do beck
    @ResponseStatus(HttpStatus.NOT_FOUND) //Erro do Http
    public Map<String, String> tratarErro(RuntimeException ex){
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", ex.getMessage());
        return erro;
    }
}
