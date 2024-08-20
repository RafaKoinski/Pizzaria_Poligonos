package com.pizzaria.poligonos.Domain.ItemPedido;

import com.pizzaria.poligonos.Domain.Pedido.PedidoJPA;
import com.pizzaria.poligonos.Domain.Produto.ProdutoJPA;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "itempedidos")
@Entity(name = "itempedidos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemPedidoJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoJPA id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private ProdutoJPA produto;

    private int quantidade;

    private float preco;

    public ItemPedidoJPA(ItemPedidoJPA itemPedido) {
        this(itemPedido.getId(), itemPedido.getId_pedido(), itemPedido.getProduto(), itemPedido.getQuantidade(), itemPedido.getPreco());
    }

}
