package com.pizzaria.poligonos.Domain.Produto;

import jakarta.validation.constraints.NotBlank;

public record Produto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String imagem,
        @NotBlank
        String grupo) {
}
