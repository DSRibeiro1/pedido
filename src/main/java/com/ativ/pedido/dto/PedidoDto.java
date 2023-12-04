package com.ativ.pedido.dto;

import java.time.LocalDate;

import com.ativ.pedido.entities.Pedido;

public class PedidoDto {
    private final int id;
    private final LocalDate data;
    private final int quantidade;

    // Construtor que aceita uma instância de Pedido para inicializar o DTO
    public PedidoDto(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }
        if (pedido.getData() == null) {
            throw new IllegalArgumentException("Campos críticos do pedido não podem ser nulos");
        }
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.quantidade = pedido.getQuantidade();
    }

    // Método de acesso para obter o ID do pedido
    public int getId() {
        return this.id;
    }

    // Método de acesso para obter a data do pedido
    public LocalDate getData() {
        return this.data;
    }

    // Método de acesso para obter a quantidade do pedido
    public int getQuantidade() {
        return this.quantidade;
    }
}
