package com.ativ.pedido.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ativ.pedido.dto.UsuarioDto;
import com.ativ.pedido.entities.Usuario;
import com.ativ.pedido.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository uRepository;

    // Interface de serviço para codificação de senhas.
    // private final PasswordEncoder passwordEncoder;

    // Metodo construtor. Injetando dependencia uRepository no construtor
    public UsuarioService(UsuarioRepository uRepository) {
        this.uRepository = uRepository;
        // Codificar e autenticar senhas.
        // this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<UsuarioDto> lista() {
        // uRepository.findAll().stream() --> Obtém todos os usuários do repositório,
        // converte para UsuarioDto e coleta em uma lista.
        return uRepository.findAll().stream()
                .map(UsuarioDto::new) // Converte cada usuario em UsuarioDTO
                .collect(Collectors.toList()); // Coleta os objetos UsuarioDto em uma lista

        // Retorna a lista de UsuarioDto

    }

    public void salvar(Usuario usuario) {
        // Codifique a senha bruta.
        // String senhaEncoder = this.passwordEncoder.encode(usuario.getSenha());
        // usuario.setSenha(senhaEncoder);
        uRepository.save(usuario);

    }

    public UsuarioDto busca(int id) {
        // Usuario usuario = new Usuario();
        // usuario = uRepository.findById(id).get();
        // UsuarioDto dto = new UsuarioDto(usuario);
        // return dto;

        // Objeto usuario irá armazenar um ID encontrado no Repositório
        Usuario usuario = uRepository.findById(id).orElse(null);

        // Retorne um objeto UsuarioDto criado a partir de usuario se usuario não for
        // null, caso contrário, retorne null
        return usuario != null ? new UsuarioDto(usuario) : null;
    }

    public void excluir(int id) {
        // Chama o método 'deleteById' do repositório de usuários para excluir o usuário
        // com o ID fornecido.
        uRepository.deleteById(id);

    }

    public boolean updateUsuarioByName(String nome, Usuario updateUsuario) {
        // Procura um usuário pelo nome na base de dados.
        Optional<Usuario> existingUsuarioOptional = uRepository.findByNome(nome);

        if (existingUsuarioOptional.isPresent()) {
            // Se um usuário com o nome fornecido for encontrado, atualiza suas informações.

            // Obtém o usuário existente a partir do Optional.
            Usuario existingUsuario = existingUsuarioOptional.get();

            // Atualiza os campos do usuário existente com as informações do usuário
            // atualizado.
            existingUsuario.setNome(updateUsuario.getNome());
            existingUsuario.setCpf(updateUsuario.getCpf());
            existingUsuario.setEmail(updateUsuario.getEmail());

            // Salva as alterações na base de dados.
            uRepository.save(existingUsuario);

            // Retorna verdadeiro para indicar que a atualização foi bem-sucedida.
            return true;
        } else {
            // Se nenhum usuário com o nome fornecido for encontrado, retorna falso.
            return false;
        }
    }
}
