package com.pizzaria.poligonos.Domain.ItemPedido;

import com.pizzaria.poligonos.Repository.ItemPedidoRepository;
import com.pizzaria.poligonos.Repository.PedidoRepository;
import com.pizzaria.poligonos.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenciarItem {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ItemPedidoJPA incluir(ItemPedido dados){
        var pedido = pedidoRepository.getReferenceById(dados.id_pedido());
        var produto = produtoRepository.getReferenceById(dados.id_produto());
        var itemdosPedido = new ItemPedidoJPA(null, pedido, produto, dados.quantidade(), dados.preco());
        itemPedidoRepository.save(itemdosPedido);
        return new ItemPedidoJPA(itemdosPedido);
    }
    public ItemPedidoJPA listar(Long id){
        var pedido = pedidoRepository.getReferenceById(id);
        var id_pedido = pedido.getId();
        var listaItem = itemPedidoRepository.findAllById_pedido(id_pedido);
        return  new ItemPedidoJPA(listaItem);
    }
}
