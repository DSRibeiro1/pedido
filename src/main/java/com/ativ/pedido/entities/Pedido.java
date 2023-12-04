package com.ativ.pedido.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {
    // Identificador único do pedido
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Data em que o pedido foi realizado
    private LocalDate data;

    // Quantidade de produtos no pedido
    private int quantidade;

    // Usuário associado ao pedido
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario;

    // Forma de pagamento escolhida para o pedido
    @ManyToOne(cascade = CascadeType.REFRESH)
    private FormaDePagamento formaDePagamento;

    // Endereço de entrega do pedido
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Endereco endereco;

    // Lista de produtos incluídos no pedido, com anotação para ignorar na
    // serialização JSON
    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<Produto> produtos;

    // Métodos de acesso para a lista de produtos
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // Construtor padrão
    public Pedido() {

    }

    // Métodos de acesso para o ID do pedido
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos de acesso para a data do pedido
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    // Métodos de acesso para o usuário associado ao pedido
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Métodos de acesso para a forma de pagamento do pedido
    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    // Métodos de acesso para o endereço de entrega do pedido
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Métodos de acesso para a quantidade de produtos no pedido
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método toString para fornecer uma representação legível em string do objeto
    // Pedido
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nCódigo do pedido: nº").append(id)
                .append("\nData do pedido: ").append(data)
                .append("\nQuantidade do pedido: ").append(quantidade)
                .append("\nUsuario: ").append(usuario.getNome()).append("\n")
                .append("\nEndereco ").append("\n")
                .append("\n Rua: ").append(endereco.getRua())
                .append("\n Nº: ").append(endereco.getNumero())
                .append("\n Bairro: ").append(endereco.getBairro())
                .append("\n Cidade: ").append(endereco.getCidade())
                .append("\n CEP: ").append(endereco.getCep()).append("\n")
                .append("\nTipo de pagamento: ").append(formaDePagamento.getTipo());

        return builder.toString();
    }
}
