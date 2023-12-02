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

import com.ativ.pedido.dto.FormaDePagamentoDto;
import com.ativ.pedido.entities.FormaDePagamento;
import com.ativ.pedido.services.FormaDePagamentoService;

// Indica que esta classe é um controlador Spring que manipula requisições relacionadas a formas de pagamento.
@RestController
@RequestMapping(value = "/formaDePagamento")
public class FormaDePagamentoController {

    // Injeta o serviço FormaDePagamentoService no controlador para manipulação de
    // lógica de negócios.
    private final FormaDePagamentoService service;

    // Construtor da classe que recebe um FormaDePagamentoService como parâmetro.
    public FormaDePagamentoController(FormaDePagamentoService service) {
        this.service = service;
    }

    // Mapeia requisições GET para "/formaDePagamento/lista" e retorna a lista de
    // formas de pagamento.
    @GetMapping("/lista")
    private List<FormaDePagamentoDto> lista() {
        return service.lista();
    }

    // Mapeia requisições POST para "/formaDePagamento/cadastro" para cadastrar uma
    // nova forma de pagamento.
    @PostMapping("/cadastro")
    private void cadastro(FormaDePagamento formaDePagamento) {
        service.salvar(formaDePagamento);
    }

    // Mapeia requisições GET para "/formaDePagamento/busca/{id}" e retorna a forma
    // de pagamento com o ID fornecido.
    @GetMapping("/busca/{id}")
    private FormaDePagamento busca(@PathVariable int id) {
        return service.busca(id);
    }

    // Mapeia requisições DELETE para "/formaDePagamento/excluir/{id}" para excluir
    // a forma de pagamento com o ID fornecido.
    @DeleteMapping("/excluir/{id}")
    private void excluir(@PathVariable int id) {
        service.excluir(id);
    }

    // Este método é mapeado para manipular requisições PUT na URL
    // "/alterar/{tipo}".
    @PutMapping("/alterar/{tipo}")
    private ResponseEntity<String> updateFormaDePagamentoByTipo(@PathVariable String tipo,
            @RequestBody FormaDePagamento updateFormaDePagamento) {

        // Chama um serviço para tentar atualizar uma forma de pagamento com base no
        // tipo fornecido.
        if (service.updateFormaDePagamentoByTipo(tipo, updateFormaDePagamento)) {

            // Se a atualização for bem-sucedida, retorna uma resposta HTTP 200 (OK).
            return ResponseEntity.ok("FormaDePagamento updated successfully.");
        } else {
            // Se a atualização não for bem-sucedida (forma de pagamento não encontrada),
            // retorna uma resposta HTTP 404 (Not Found).
            return ResponseEntity.notFound().build();
        }
    }
}
