package com.pizzaria.poligonos.Repository;

import com.pizzaria.poligonos.Domain.Pedido.PedidoJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoJPA, Long> {
}
