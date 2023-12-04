package com.ativ.pedido.dto;

import com.ativ.pedido.entities.Produto;

// Esta classe representa um Objeto de Transferência de Dados (DTO) para a entidade Produto.
public class ProdutoDto {

    // Identificador único para o ProdutoDto.
    private final int id;

    // Descrição do produto.
    private final String descricao;

    // Construtor que recebe uma entidade Produto e inicializa o DTO com seus dados.
    public ProdutoDto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        if (produto.getDescricao() == null) {
            throw new IllegalArgumentException("Campos críticos do produto não podem ser nulos");
        }

        this.id = produto.getId();
        this.descricao = produto.getDescricao();
    }

    // Método getter para recuperar o id do ProdutoDto.
    public int getId() {
        return this.id;
    }

    // Método getter para recuperar a descrição do ProdutoDto.
    public String getDescricao() {
        return this.descricao;
    }
}
