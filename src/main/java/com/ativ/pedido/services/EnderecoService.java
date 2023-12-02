package com.ativ.pedido.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ativ.pedido.dto.EnderecoDto;
import com.ativ.pedido.entities.Endereco;
import com.ativ.pedido.repository.EnderecoRepository;

@Service
public class EnderecoService {

    private final EnderecoRepository eRepository;

    public EnderecoService(EnderecoRepository eRepository) {
        this.eRepository = eRepository;
    }

    // Retorna uma lista de todos os endereços cadastrados.
    public List<EnderecoDto> lista() {
        return eRepository.findAll().stream()
                .map(EnderecoDto::new)
                .collect(Collectors.toList());
    }

    // Salva um novo endereço no banco de dados.
    public void salvar(Endereco endereco) {
        eRepository.save(endereco);
    }

    /*
     * Busca um endereço pelo ID e retorna o endereço encontrado, ou null se não
     * existir.
     */
    public Endereco busca(int id) {
        return eRepository.findById(id).orElse(new Endereco());
        // (null) --> null não é recomendado

        /*
         * Optional<Endereco> optionalEndereco = eRepository.findById(id);
         * * return optionalEndereco.orElse(null);
         */
    }

    // Exclui um endereço com base no ID fornecido.
    public void excluir(int id) {
        eRepository.deleteById(id);
    }

    public boolean updateEnderecoByRua(String rua, Endereco updateEndereco) {
        // Procura "rua" na base de dados.
        Optional<Endereco> existingEnderecoOptional = eRepository.findByRua(rua);

        if (existingEnderecoOptional.isPresent()) {
            // Se um endereço com a rua fornecida for encontrado, atualiza suas informações.

            // Obtém o endereço existente a partir do Optional.
            Endereco existingEndereco = existingEnderecoOptional.get();

            // Atualiza os campos do endereço existente com as informações do endereço
            // atualizado.
            existingEndereco.setRua(updateEndereco.getRua());
            existingEndereco.setNumero(updateEndereco.getNumero());
            existingEndereco.setBairro(updateEndereco.getBairro());
            existingEndereco.setCep(updateEndereco.getCep());
            existingEndereco.setCidade(updateEndereco.getCidade());

            // Salva as alterações na base de dados.
            eRepository.save(existingEndereco);

            // Retorna verdadeiro para indicar que a atualização foi bem-sucedida.
            return true;
        } else {
            // Se nenhum endereço com a rua fornecida for encontrado, retorna falso.
            return false;
        }
    }
}
