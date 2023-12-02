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

import com.ativ.pedido.dto.ProdutoDto;
import com.ativ.pedido.entities.Produto;
import com.ativ.pedido.services.ProdutoService;

// Indica que esta classe é um controlador Spring que manipula requisições relacionadas a produtos.
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    // Injeta o serviço ProdutoService no controlador para manipulação de lógica de
    // negócios.
    private final ProdutoService service;

    // Construtor da classe que recebe um ProdutoService como parâmetro.
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    // Mapeia requisições GET para "/produto/lista" e retorna a lista de produtos.
    @GetMapping("/lista")
    private List<ProdutoDto> lista() {
        return service.lista();
    }

    // Mapeia requisições POST para "/produto/cadastro" para cadastrar um novo
    // produto.
    @PostMapping("/cadastro")
    private void cadastro(Produto produto) {
        service.salvar(produto);
    }

    // Mapeia requisições GET para "/produto/busca/{id}" e retorna o produto com o
    // ID fornecido.
    @GetMapping("/busca/{id}")
    private Produto busca(@PathVariable int id) {
        return service.busca(id);
    }

    // Mapeia requisições DELETE para "/produto/excluir/{id}" para excluir o produto
    // com o ID fornecido.
    @DeleteMapping("/excluir/{id}")
    private void excluir(@PathVariable int id) {
        service.excluir(id);
    }

    @PutMapping("/alterar/{descricao}")
    private ResponseEntity<String> updateProdutoByDescricao(@PathVariable String descricao,
            @RequestBody Produto updateProduto) {

        // Chama um serviço para tentar atualizar um produto com base no item fornecido.
        if (service.updateProdutoByDescricao(descricao, updateProduto)) {

            // Se a atualização for bem-sucedida, retorna uma resposta HTTP 200 (OK).
            return ResponseEntity.ok("Produto updated successfully.");
        } else {
            // Se a atualização não for bem-sucedida (produto não encontrado), retorna uma
            // resposta HTTP 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }
}
