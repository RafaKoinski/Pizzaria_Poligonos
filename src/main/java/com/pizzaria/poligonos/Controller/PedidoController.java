package com.pizzaria.poligonos.Controller;

import com.pizzaria.poligonos.Domain.Pedido.*;
import com.pizzaria.poligonos.Repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private AgendarPedido agendar;

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity pedir(@RequestBody @Valid Pedido dados){
        var pedidos = agendar.pedir(dados);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping
    public ResponseEntity<Page<ListaPedido>> ListarPedido(@PageableDefault(size = 30, sort = {"id"}) Pageable pag){
        return ResponseEntity.ok(repository.findAll(pag).map(ListaPedido::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarPedido dados){
        var pedido = repository.getReferenceById(dados.id());
        pedido.atualizarInformacoes(dados);
        pedido = repository.getReferenceById(dados.id());
        return ResponseEntity.ok(new DetalhesPedido(pedido));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cancelar(@PathVariable Long id){
        var pedido = repository.getReferenceById(id);
        repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }
}
