package com.ativ.pedido.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ativ.pedido.dto.ProdutoDto;
import com.ativ.pedido.entities.Produto;
import com.ativ.pedido.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository prodRepository;

    public ProdutoService(ProdutoRepository prodRepository) {
        this.prodRepository = prodRepository;
    }

    // Comentário: Retorna uma lista de todos os produtos.
    public List<ProdutoDto> lista() {
        return prodRepository.findAll()
                .stream()
                .map(ProdutoDto::new) // Converte cada usuario em UsuarioDTO
                .collect(Collectors.toList()); // Coleta os objetos UsuarioDto em uma lista

        // Retorna a lista de UsuarioDto

    }

    // Comentário: Salva um novo produto no banco de dados.
    public void salvar(Produto produto) {
        prodRepository.save(produto);
    }

    // Comentário: Busca um produto pelo ID. Retorna um Produto ou um novo Produto
    // se não encontrado.
    public ProdutoDto busca(Integer id) {
        // return prodRepository.findById(id).orElse(new Produto());
        Produto produto = prodRepository.findById(id).orElse(new Produto());

        return produto != null ? new ProdutoDto(produto) : null;
    }

    // Comentário: Exclui um produto pelo ID.
    public void excluir(Integer id) {
        prodRepository.deleteById(id);
    }

    public boolean updateProdutoByDescricao(String descricao, Produto updateProduto) {
        // Procura um Produto pelo item na base de dados.
        Optional<Produto> existingProdutoOptional = prodRepository.findByDescricao(descricao);

        if (existingProdutoOptional.isPresent()) {
            // Se um Produto com o item fornecido for encontrado, atualiza suas informações.

            // Obtém o Produto existente a partir do Optional.
            Produto existingProduto = existingProdutoOptional.get();

            // Atualiza os campos do Produto existente com as informações do Produto
            // atualizado.

            existingProduto.setDescricao(updateProduto.getDescricao());

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
