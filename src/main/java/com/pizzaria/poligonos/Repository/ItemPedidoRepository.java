package com.pizzaria.poligonos.Repository;

import com.pizzaria.poligonos.Domain.ItemPedido.ItemPedidoJPA;
import com.pizzaria.poligonos.Domain.Pedido.PedidoJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoJPA, Long> {

    @Query("""
            SELECT i FROM itempedidos i
            WHERE
            i.pedido.id = :pedido
            """)
    List<ItemPedidoJPA> findAllById_pedido(Long pedido);

}
