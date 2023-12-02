package com.ativ.pedido.dto;

import com.ativ.pedido.entities.FormaDePagamento;

public class FormaDePagamentoDto {

    private int id;
    private String tipo;

    // public UsuarioDto() {
    // }

    public FormaDePagamentoDto(FormaDePagamento formaDePagamento) {
        this.id = formaDePagamento.getId();
        this.tipo = formaDePagamento.getTipo();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
