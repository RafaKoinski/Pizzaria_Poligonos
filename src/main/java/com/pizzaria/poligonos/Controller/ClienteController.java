package com.pizzaria.poligonos.Controller;

import com.pizzaria.poligonos.Domain.Cliente.AtualizaCliente;
import com.pizzaria.poligonos.Domain.Cliente.Cliente;
import com.pizzaria.poligonos.Domain.Cliente.ClienteJPA;
import com.pizzaria.poligonos.Repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Console;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid Cliente dados, UriComponentsBuilder uriBuilder){
        var cliente = new ClienteJPA(dados);
        repository.save(cliente);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteJPA(cliente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados, cliente.getCep());
        cliente = repository.getReferenceById(dados.id());
        return ResponseEntity.ok(new ClienteJPA(cliente));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir();
        return ResponseEntity.noContent().build();
    }

}
