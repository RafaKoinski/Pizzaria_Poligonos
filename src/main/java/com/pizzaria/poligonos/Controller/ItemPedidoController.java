package com.pizzaria.poligonos.Controller;

import com.pizzaria.poligonos.Domain.ItemPedido.GerenciarItem;
import com.pizzaria.poligonos.Domain.ItemPedido.ItemPedido;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    private GerenciarItem gerenciarItem;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ItemPedido dados){
        var itemPedido = gerenciarItem.incluir(dados);
        return ResponseEntity.ok(itemPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarItemPedido(@PathVariable Long id){
        var listaItens = gerenciarItem.listar(id);
        return ResponseEntity.ok(listaItens);
    }
}
