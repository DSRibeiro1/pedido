package com.ativ.pedido.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ativ.pedido.dto.UsuarioDto;
import com.ativ.pedido.entities.Usuario;
import com.ativ.pedido.services.UsuarioService;

// Indica que esta classe é um controlador Spring que manipula requisições relacionadas a usuários.
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    // Injeta o serviço UsuarioService no controlador para manipulação de lógica de
    // negócios relacionada a usuários.
    private final UsuarioService service;

    // Construtor da classe que recebe um UsuarioService como parâmetro.
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Mapeia requisições GET para "/usuario/lista" e retorna uma lista de usuários
    // no formato de UsuarioDto.
    @GetMapping("/lista")
    private List<UsuarioDto> lista() {
        return service.lista();
    }

    // Mapeia requisições POST para "/usuario/cadastro" para cadastrar um novo
    // usuário.
    @PostMapping("/cadastro")
    private void cadastro(Usuario usuario) {
        service.salvar(usuario);
        System.out.println("Recebido usuário: " + usuario);

    }

    // Comentário: Este método é mapeado para a URL "/usuario/busca/{id}" e trata
    // solicitações GET para buscar um usuário por ID.
    @GetMapping("/busca/{id}")
    private UsuarioDto busca(@PathVariable int id) {// , @AuthenticationPrincipal OidcUser principal) {

        return service.busca(id);

    }

    @DeleteMapping("/excluir/{id}")
    private void excluir(@PathVariable int id) {
        service.excluir(id);
    }

    // Davi --> username: davi.ribeiro / senha 123
    // @PostMapping("/login")
    // private ResponseEntity<String> login(@RequestBody UsuarioLoginDto usuario) {
    // return service.autentica(usuario);
    // }

    // Este método é mapeado para manipular requisições PUT na URL
    // "/alterar/{nome}".
    @PutMapping("/alterar/{nome}")
    private ResponseEntity<String> updateUsuarioByName(@PathVariable String nome, @RequestBody Usuario updateUsuario) {

        // Chama um serviço para tentar atualizar o usuário pelo nome fornecido.
        if (service.updateUsuarioByName(nome, updateUsuario)) {

            // Se a atualização for bem-sucedida, retorna uma resposta HTTP 200 (OK).
            return ResponseEntity.ok("Usuario updated successfully.");
        } else {
            // Se a atualização não for bem-sucedida (usuário não encontrado), retorna uma
            // resposta HTTP 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }
}
