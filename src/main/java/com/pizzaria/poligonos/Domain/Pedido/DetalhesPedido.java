package com.pizzaria.poligonos.Domain.Pedido;

import java.time.LocalDateTime;

public record DetalhesPedido(Long id, Long id_cliente, LocalDateTime data, String status) {
    public DetalhesPedido(PedidoJPA pedido) {
        this(pedido.getId(), pedido.getCliente().getId(), pedido.getData(), pedido.getStatus());
    }
}
