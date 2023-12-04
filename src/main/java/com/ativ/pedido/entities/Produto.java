package com.ativ.pedido.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
    // Identificador único do produto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Descrição do produto
    private String descricao;

    // Pedido associado a este produto
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Pedido pedido;

    // Construtor padrão
    public Produto() {

    }

    // Métodos de acesso para o ID do produto
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos de acesso para a descrição do produto
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Métodos de acesso para o pedido associado ao produto
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
