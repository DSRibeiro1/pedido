package com.ativ.pedido.dto;

import java.sql.Date;

import com.ativ.pedido.entities.Pedido;

public class PedidoDto {
    private int id;
    private Date data;
    private int quantidade;

    public PedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.quantidade = pedido.getQuantidade();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
