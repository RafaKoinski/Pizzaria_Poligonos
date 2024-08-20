package com.pizzaria.poligonos.Domain.ItemPedido;

import jakarta.validation.constraints.NotNull;

public record ItemPedido(

        Long id,
        @NotNull
        Long id_pedido,
        @NotNull
        Long id_produto,

        int quantidade,
        float preco) {

}
