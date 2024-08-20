package com.pizzaria.poligonos.Repository;

import com.pizzaria.poligonos.Domain.ItemPedido.ItemPedidoJPA;
import com.pizzaria.poligonos.Domain.Pedido.PedidoJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoJPA, Long> {

    @Query("""
            SELECT i FROM itempedidos i
            WHERE
            i.id_pedido = :pedido
            """)
    ItemPedidoJPA findAllById_pedido(Long pedido);

}
