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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data;
    private int quantidade;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private FormaDePagamento formaDePagamento;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Pedido() {

    }

    public Pedido(LocalDate data, int quantidade, Usuario usuario, FormaDePagamento formaDePagamento,
            Endereco endereco) {
        this.data = data;
        this.quantidade = quantidade;
        this.usuario = usuario;
        this.formaDePagamento = formaDePagamento;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

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
