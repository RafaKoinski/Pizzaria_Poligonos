package com.pizzaria.poligonos.Domain.Pedido;

import jakarta.validation.constraints.NotNull;

public record AtualizarPedido(
        @NotNull
        Long id,
        String status) {
}
