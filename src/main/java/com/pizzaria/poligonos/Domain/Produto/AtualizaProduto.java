package com.pizzaria.poligonos.Domain.Produto;

import jakarta.validation.constraints.NotNull;

public record AtualizaProduto(

        @NotNull
        Long id,
        String nome,
        String descricao,
        String imagem,
        String grupo) {
}
