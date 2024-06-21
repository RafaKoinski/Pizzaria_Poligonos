package com.pizzaria.poligonos.Domain.Cliente;

import jakarta.validation.constraints.NotNull;

public record AtualizaCliente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        String login,
        String endereco,
        String bairro,
        int cep,
        String uf,
        String cidade,
        String num,
        String complemento) {
}
