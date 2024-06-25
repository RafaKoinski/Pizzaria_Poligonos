package com.pizzaria.poligonos.Domain.Pedido;

import com.pizzaria.poligonos.Domain.Cliente.ClienteJPA;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "Pedidos")
@Entity(name = "Pedidos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PedidoJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteJPA cliente;

    private String status;

    private LocalDateTime data;

    public PedidoJPA(PedidoJPA pedido) {
        this(pedido.getId(), pedido.getCliente(), pedido.getStatus(), pedido.getData());
    }

    public void atualizarInformacoes(AtualizarPedido dados) {
        if (dados.status() != null){
            this.status = dados.status();
        }
    }
}
