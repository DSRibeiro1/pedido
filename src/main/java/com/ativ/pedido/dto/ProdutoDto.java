package com.ativ.pedido.dto;

import com.ativ.pedido.entities.Produto;

public class ProdutoDto {

    private int id;
    private String descricao;

    // public UsuarioDto() {
    // }

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

}
