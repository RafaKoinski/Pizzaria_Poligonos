package com.pizzaria.poligonos.Controller;

import com.pizzaria.poligonos.Domain.Produto.ListaProduto;
import com.pizzaria.poligonos.Domain.Produto.Produto;
import com.pizzaria.poligonos.Domain.Produto.ProdutoJPA;
import com.pizzaria.poligonos.Repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid Produto dados, UriComponentsBuilder uriBuilder){
        var produto = new ProdutoJPA(dados);
        repository.save(produto);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoJPA(produto));
    }

    @GetMapping
    public ResponseEntity<Page<ListaProduto>> ListarProduto(@PageableDefault(sort = {"nome"}) Pageable pag){
        return ResponseEntity.ok(repository.findAllByAtivoTrue(pag).map(ListaProduto::new));
    }
}
