package com.pizzaria.poligonos.Controller;

import com.pizzaria.poligonos.Domain.Produto.AtualizaProduto;
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
    public ResponseEntity<Page<ListaProduto>> ListarProduto(@PageableDefault(size = 20,sort = {"nome"}) Pageable pag){
        return ResponseEntity.ok(repository.findAllByAtivoTrue(pag).map(ListaProduto::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaProduto dados){
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);
        produto = repository.getReferenceById(dados.id());
        return ResponseEntity.ok(new ProdutoJPA(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var produto = repository.getReferenceById(id);
        produto.excluir();
        return ResponseEntity.noContent().build();
    }
}
