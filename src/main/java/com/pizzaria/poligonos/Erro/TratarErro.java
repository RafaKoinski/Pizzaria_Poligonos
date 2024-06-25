package com.pizzaria.poligonos.Erro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarErro {

    @ExceptionHandler(ValidacaoExcepion.class)
    public ResponseEntity tratarErroRequisicao(ValidacaoExcepion ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
