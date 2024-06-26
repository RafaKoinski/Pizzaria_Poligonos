package com.pizzaria.poligonos.Domain.Produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Produtos")
@Entity(name = "Produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoJPA {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private String imagem;
    private String grupo;
    private boolean ativo;

    public ProdutoJPA(Produto dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.imagem = dados.imagem();
        this.grupo = dados.grupo();
    }

    public ProdutoJPA(ProdutoJPA produto) {
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getImagem(), produto.getGrupo(), produto.isAtivo());
    }

    public void atualizarInformacoes(AtualizaProduto dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.imagem() != null){
            this.imagem = dados.imagem();
        }
        if (dados.grupo() != null){
            this.grupo = dados.grupo();
        }
    }

    public void excluir(){ this.ativo = false; }
}
