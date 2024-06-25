package com.pizzaria.poligonos.Domain.Pedido;

import com.pizzaria.poligonos.Erro.ValidacaoExcepion;
import com.pizzaria.poligonos.Repository.ClienteRepository;
import com.pizzaria.poligonos.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendarPedido {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public DetalhesPedido pedir(Pedido dados) {
        var cliente = clienteRepository.getReferenceById(dados.id_cliente());
        var abertura = dados.data().getHour() < 18;
        var fechamento = dados.data().getHour() > 23;


        if (abertura || fechamento){
            throw new ValidacaoExcepion("Estamos fechados! O horário de funcionamento é de seg a seg das 18hrs ás 23hrs");
        }

        var pedido = new PedidoJPA(null, cliente, dados.status(), dados.data());

        pedidoRepository.save(pedido);
        return new DetalhesPedido(pedido);
    }
}
