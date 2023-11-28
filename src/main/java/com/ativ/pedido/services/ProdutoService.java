package com.ativ.pedido.services;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;

import com.ativ.pedido.entities.Produto;
import com.ativ.pedido.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository prodRepository;

    public ProdutoService(ProdutoRepository prodRepository) {
        this.prodRepository = prodRepository;
    }

    // Comentário: Retorna uma lista de todos os produtos.
    public List<Produto> lista() {
        return prodRepository.findAll();
    }

    // Comentário: Salva um novo produto no banco de dados.
    public void salvar(Produto produto) {
        prodRepository.save(produto);
    }

    // Comentário: Busca um produto pelo ID. Retorna um Produto ou um novo Produto
    // se não encontrado.
    public Produto busca(Integer id) {
        return prodRepository.findById(id).orElse(new Produto());
    }

    // Comentário: Exclui um produto pelo ID.
    public void excluir(Integer id) {
        prodRepository.deleteById(id);
    }

    public boolean updateProdutoByNome(String nome, Produto updateProduto) {
        // Procura um Produto pelo item na base de dados.
        Optional<Produto> existingProdutoOptional = prodRepository.findByNome(nome);

        if (existingProdutoOptional.isPresent()) {
            // Se um Produto com o item fornecido for encontrado, atualiza suas informações.

            // Obtém o Produto existente a partir do Optional.
            Produto existingProduto = existingProdutoOptional.get();

            // Atualiza os campos do Produto existente com as informações do Produto
            // atualizado.
            existingProduto.setNome(updateProduto.getNome());
            existingProduto.setDescricao(updateProduto.getDescricao());
            existingProduto.setPreco(updateProduto.getPreco());

            // Salva as alterações na base de dados.
            prodRepository.save(existingProduto);

            // Retorna verdadeiro para indicar que a atualização foi bem-sucedida.
            return true;
        } else {
            // Se nenhum Produto com o item fornecido for encontrado, retorna falso.
            return false;
        }

    }
}
