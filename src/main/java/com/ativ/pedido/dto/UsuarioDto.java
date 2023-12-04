package com.ativ.pedido.dto;

import com.ativ.pedido.entities.Usuario;

// Esta classe representa um Objeto de Transferência de Dados (DTO) para a entidade Usuario.
public class UsuarioDto {

    // Identificador único para o UsuarioDto.
    private final int id;

    // Nome do usuário.
    private final String nome;

    // Nome de usuário utilizado para login.
    private final String username;

    // Endereço de e-mail associado ao usuário.
    private final String email;

    // Número do CPF do usuário.
    private final String cpf;

    // Construtor que recebe uma entidade Usuario e inicializa o DTO com seus dados.
    public UsuarioDto(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario não pode ser nulo");
        }
        if (usuario.getNome() == null || usuario.getUsername() == null || usuario.getEmail() == null
                || usuario.getCpf() == null) {
            throw new IllegalArgumentException("Campos críticos do endereço não podem ser nulos");
        }
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
    }

    // Método getter para recuperar o id do UsuarioDto.
    public int getId() {
        return this.id;
    }

    // Método getter para recuperar o nome do UsuarioDto.
    public String getNome() {
        return this.nome;
    }

    // Método getter para recuperar o nome de usuário do UsuarioDto.
    public String getUsername() {
        return this.username;
    }

    // Método getter para recuperar o e-mail do UsuarioDto.
    public String getEmail() {
        return this.email;
    }

    // Método getter para recuperar o CPF do UsuarioDto.
    public String getCpf() {
        return cpf;
    }

}
