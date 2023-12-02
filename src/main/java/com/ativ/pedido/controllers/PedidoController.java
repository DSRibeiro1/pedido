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

import com.ativ.pedido.dto.PedidoDto;
import com.ativ.pedido.entities.Pedido;
import com.ativ.pedido.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // Comentário: Endpoint para obter a lista de todos os pedidos.
    @GetMapping("/lista")
    private List<PedidoDto> lista() {
        return service.lista();
    }

    // Comentário: Endpoint para cadastrar um novo pedido.
    @PostMapping("/cadastro")
    private void cadastro(Pedido pedido) {
        service.salvar(pedido);
    }

    // Comentário: Endpoint para buscar um pedido pelo ID.
    @GetMapping("/busca/{id}")
    private Pedido busca(@PathVariable int id) {
        return service.busca(id);
    }

    // Comentário: Endpoint para excluir um pedido pelo ID.
    @DeleteMapping("/excluir/{id}")
    private void excluir(@PathVariable int id) {
        service.excluir(id);
    }

    // Este método é mapeado para manipular requisições PUT na URL
    // "/alterar/{item}".
    @PutMapping("/alterar/{quantidade}")
    private ResponseEntity<String> updatePedidoByQuantidade(@PathVariable int quantidade,
            @RequestBody Pedido updatePedido) {

        // Chama um serviço para tentar atualizar um pedido com base no item fornecido.
        if (service.updatePedidoByItem(quantidade, updatePedido)) {

            // Se a atualização for bem-sucedida, retorna uma resposta HTTP 200 (OK).
            return ResponseEntity.ok("Pedido updated successfully.");
        } else {
            // Se a atualização não for bem-sucedida (pedido não encontrado), retorna uma
            // resposta HTTP 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }
}
