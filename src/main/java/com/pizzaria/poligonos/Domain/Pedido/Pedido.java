package com.pizzaria.poligonos.Domain.Pedido;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record Pedido(

        @NotNull
        Long id_cliente,
        LocalDateTime data,
        String status) {
}
