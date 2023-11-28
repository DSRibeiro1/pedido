package com.ativ.pedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ativ.pedido.entities.FormaDePagamento;
import com.ativ.pedido.repository.FormaDePagamentoRepository;

@Service
public class FormaDePagamentoService {

    // Comentário: O repositório `FormaDePagamentoRepository` é injetado no serviço
    // para permitir a interação
    // com as formas de pagamento armazenadas no banco de dados.
    private final FormaDePagamentoRepository fRepository;

    // Comentário: Construtor que injeta o repositório necessário para interagir com
    // as formas de pagamento.
    public FormaDePagamentoService(FormaDePagamentoRepository fRepository) {
        this.fRepository = fRepository;
    }

    // Comentário: Retorna uma lista de todas as formas de pagamento cadastradas.
    public List<FormaDePagamento> lista() {
        return fRepository.findAll();
    }

    // Comentário: Salva uma nova forma de pagamento no sistema.
    public void salvar(FormaDePagamento formaDePagamento) {
        fRepository.save(formaDePagamento);
    }

    /*
     * Busca Forma De Pagamento pelo ID e retorna Forma De Pagamento encontrado, ou
     * null se não existir.
     */
    public FormaDePagamento busca(int id) {
        return fRepository.findById(id).orElse(new FormaDePagamento());
        // (null) --> null não é recomendado

        // Optional<FormaDePagamento> optionalFormaDePagamento =
        // fRepository.findById(id);
        // return optionalFormaDePagamento.orElse(null);
    }

    public void excluir(int id) {
        fRepository.deleteById(id);

    }

    public boolean updateFormaDePagamentoByTipo(String tipo, FormaDePagamento updateFormaDePagamento) {
        // Procura uma forma de pagamento pelo tipo na base de dados.
        Optional<FormaDePagamento> existingFormaDePagamentoOptional = fRepository.findByTipo(tipo);

        if (existingFormaDePagamentoOptional.isPresent()) {
            // Se uma forma de pagamento com o tipo fornecido for encontrada, atualiza suas
            // informações.

            // Obtém a forma de pagamento existente a partir do Optional.
            FormaDePagamento existingFormaDePagamento = existingFormaDePagamentoOptional.get();

            // Atualiza o campo "tipo" da forma de pagamento existente com o tipo fornecido
            // no "updateFormaDePagamento".
            existingFormaDePagamento.setTipo(updateFormaDePagamento.getTipo());

            // Salva as alterações na base de dados.
            fRepository.save(existingFormaDePagamento);

            // Retorna verdadeiro para indicar que a atualização foi bem-sucedida.
            return true;
        } else {
            // Se nenhuma forma de pagamento com o tipo fornecido for encontrada, retorna
            // falso.
            return false;
        }
    }
}
