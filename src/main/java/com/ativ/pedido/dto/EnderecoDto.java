package com.ativ.pedido.dto;

import com.ativ.pedido.entities.Endereco;

public class EnderecoDto {
    private final int id;
    private final String rua;
    private final String numero;
    private final String bairro;
    private final String cep;
    private final String cidade;

    // Construtor que aceita uma instância de Endereco para inicializar o DTO
    public EnderecoDto(Endereco endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("Endereço não pode ser nulo");
        }
        if (endereco.getRua() == null || endereco.getNumero() == null || endereco.getCep() == null) {
            throw new IllegalArgumentException("Campos críticos do endereço não podem ser nulos");
        }
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
    }

    // Método de acesso para obter o ID
    public int getId() {
        return this.id;
    }

    // Método de acesso para obter a rua
    public String getRua() {
        return this.rua;
    }

    // Método de acesso para obter o número
    public String getNumero() {
        return this.numero;
    }

    // Método de acesso para obter o bairro
    public String getBairro() {
        return this.bairro;
    }

    // Método de acesso para obter o CEP
    public String getCep() {
        return this.cep;
    }

    // Método de acesso para obter a cidade
    public String getCidade() {
        return this.cidade;
    }
}
