package com.ativ.pedido.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
    // Identificador único do endereço
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Nome da rua
    private String rua;

    // Número do endereço
    private String numero;

    // Nome do bairro
    private String bairro;

    // CEP do endereço
    private String cep;

    // Nome da cidade
    private String cidade;

    // Construtor padrão
    public Endereco() {

    }

    // Métodos de acesso para o ID do endereço
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos de acesso para o nome da rua
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    // Métodos de acesso para o número do endereço
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Métodos de acesso para o nome do bairro
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    // Métodos de acesso para o CEP do endereço
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    // Métodos de acesso para o nome da cidade
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
