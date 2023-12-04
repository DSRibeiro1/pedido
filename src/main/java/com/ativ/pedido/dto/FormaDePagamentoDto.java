package com.ativ.pedido.dto;

import com.ativ.pedido.entities.FormaDePagamento;

public class FormaDePagamentoDto {

    private final int id;
    private final String tipo;

    // Construtor que aceita uma instância de FormaDePagamento para inicializar o
    // DTO
    public FormaDePagamentoDto(FormaDePagamento formaDePagamento) {
        if (formaDePagamento == null) {
            throw new IllegalArgumentException("Forma pgto não pode ser nulo");
        }
        this.id = formaDePagamento.getId();
        this.tipo = formaDePagamento.getTipo();
    }

    // Método de acesso para obter o ID
    public int getId() {
        return this.id;
    }

    // Método de acesso para obter o tipo de forma de pagamento
    public String getTipo() {
        return this.tipo;
    }

}
