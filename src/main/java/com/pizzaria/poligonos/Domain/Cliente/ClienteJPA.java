package com.pizzaria.poligonos.Domain.Cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Clientes")
@Entity(name = "Clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClienteJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String login;
    private String senha;
    private boolean ativo;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private int cep;
    private String complemento;
    private String num;

    public ClienteJPA(Cliente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.login = dados.login();
        this.senha = dados.senha();
        this.endereco = dados.endereco();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
        this.complemento = dados.complemento();
        this.num = dados.num();
    }

    public ClienteJPA(ClienteJPA cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getLogin(), cliente.getSenha(), cliente.isAtivo(),
                cliente.getEndereco(), cliente.getBairro(), cliente.getCidade(), cliente.getUf() , cliente.getCep(),
                cliente.getComplemento(), cliente.getNum());
    }

    public void atualizarInformacoes(AtualizaCliente dados, int cepAtual) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.login() != null){
            this.login = dados.login();
        }
        if (dados.endereco() != null){
            this.endereco = dados.endereco();
        }
        if (dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if (dados.uf() != null){
            this.uf = dados.uf();
        }
        if (dados.cep() != cepAtual){
            this.cep = dados.cep();
        }
        if (dados.complemento() != null){
            this.complemento = dados.complemento();
        }
        if (dados.num() != null){
            this.num = dados.num();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
