package com.pizzaria.poligonos.Domain.Cliente;


import jakarta.validation.constraints.*;

public record Cliente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        String telefone,
        boolean ativo,
        @NotBlank
        String login,
        @NotBlank
        String senha,
        @NotBlank
        String endereco,
        @NotBlank
        String bairro,
        int cep,
        @NotBlank
        String uf,
        @NotBlank
        String cidade,
        @NotBlank
        String num,
        @NotBlank
        String complemento) {
}
