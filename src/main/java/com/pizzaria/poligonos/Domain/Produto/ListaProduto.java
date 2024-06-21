package com.pizzaria.poligonos.Domain.Produto;

public record ListaProduto(Long id, String nome, String descricao, String imagem, String grupo) {

    public ListaProduto(ProdutoJPA produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getImagem(), produto.getGrupo());
    }
}
