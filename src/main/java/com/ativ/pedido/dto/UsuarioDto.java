package com.ativ.pedido.dto;

import com.ativ.pedido.entities.Usuario;

public class UsuarioDto {

    private int id;
    private String nome;
    private String username;
    private String email;
    private String cpf;

    // public UsuarioDto() {
    // }

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
