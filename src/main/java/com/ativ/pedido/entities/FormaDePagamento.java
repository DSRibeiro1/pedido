package com.ativ.pedido.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class FormaDePagamento {
    // Identificador único da forma de pagamento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Tipo da forma de pagamento (por exemplo, "Cartão de Crédito", "Boleto", etc.)
    private String tipo;

    // Lista de pedidos associados a esta forma de pagamento, com anotação para
    // ignorar na serialização JSON
    @JsonIgnore
    @OneToMany(mappedBy = "formaDePagamento")
    private List<Pedido> pedidos;

    // Construtor padrão
    public FormaDePagamento() {

    }

    // Métodos de acesso para o ID da forma de pagamento
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos de acesso para o tipo da forma de pagamento
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Métodos de acesso para a lista de pedidos associados à forma de pagamento
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
