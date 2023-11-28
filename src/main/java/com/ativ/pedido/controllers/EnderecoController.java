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

import com.ativ.pedido.entities.Endereco;
import com.ativ.pedido.services.EnderecoService;

// Indica que esta classe é um controlador Spring que manipula requisições relacionadas a endereços.
@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    // Injeta o serviço EnderecoService no controlador para manipulação de lógica de
    // negócios.
    private final EnderecoService service;

    // Construtor da classe que recebe um EnderecoService como parâmetro.
    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    // Mapeia requisições GET para "/endereco/lista" e retorna a lista de endereços.
    @GetMapping("/lista")
    private List<Endereco> lista() {
        return service.lista();
    }

    // Mapeia requisições POST para "/endereco/cadastro" para cadastrar um novo
    // endereço.
    @PostMapping("/cadastro")
    private void cadastro(@RequestBody Endereco endereco) {
        service.salvar(endereco);
    }

    // Mapeia requisições GET para "/endereco/busca/{id}" e retorna o endereço com o
    // ID fornecido.
    @GetMapping("/busca/{id}")
    private Endereco busca(@PathVariable int id) {
        return service.busca(id);
    }

    // Mapeia requisições DELETE para "/endereco/excluir/{id}" para excluir o
    // endereço com o ID fornecido.
    @DeleteMapping("/excluir/{id}")
    private void excluir(@PathVariable int id) {
        service.excluir(id);
    }

    // Este método é mapeado para manipular requisições PUT na URL "/alterar/{rua}".
    @PutMapping("/alterar/{rua}")
    private ResponseEntity<String> updateEnderecoByRua(@PathVariable String rua, @RequestBody Endereco updateEndereco) {

        // Chama um serviço para tentar atualizar um endereço com base na rua fornecida.
        if (service.updateEnderecoByRua(rua, updateEndereco)) {

            // Se a atualização for bem-sucedida, retorna uma resposta HTTP 200 (OK).
            return ResponseEntity.ok("Endereco updated successfully.");
        } else {
            // Se a atualização não for bem-sucedida (endereço não encontrado), retorna uma
            // resposta HTTP 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }
}
