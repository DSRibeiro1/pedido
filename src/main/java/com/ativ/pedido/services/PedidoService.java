package com.ativ.pedido.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ativ.pedido.dto.PedidoDto;
import com.ativ.pedido.entities.Pedido;
import com.ativ.pedido.repository.PedidoRepository;

@Service
public class PedidoService {

    // Adicionado final ao campo pRepository no construtor para indicar que ele é
    // injetado e não será alterado após a injeção.

    private final PedidoRepository pRepository;
    private final EmailService emailService;

    // Injeção de dependência no construtor para fornecer a instância de
    // PedidoRepository. Isso elimina a necessidade de usar @Autowired nos campos.
    public PedidoService(PedidoRepository pRepository, EmailService emailService) {
        this.pRepository = pRepository;
        this.emailService = emailService;
    }

    // Comentário: Retorna a lista de todos os pedidos armazenados no banco de
    // dados.
    public List<PedidoDto> lista() {

        return pRepository.findAll()
                .stream()
                .map(PedidoDto::new)
                .collect(Collectors.toList());
    }

    // Comentário: Salva o pedido no banco de dados.

    public void salvar(Pedido pedido, String emailUsuarioLogado) {
        // Adiciona logs para verificar os dados antes de salvar
        System.out.println("Dados do Pedido recebidos: " + pedido);

        try {
            // Salva o pedido no banco de dados
            pRepository.save(pedido);

            // Envia e-mail ao usuário logado
            enviarEmailPedidoCadastrado(emailUsuarioLogado, pedido);
        } catch (Exception e) {
            // Trata exceções aqui (registra logs, notifica administradores, etc.)
            throw new RuntimeException("Erro ao salvar o pedido", e);
        }

        // Adiciona logs para verificar os dados após salvar
        System.out.println("Dados do Pedido salvos: " + pedido);
    }

    /**
     * Envia um e-mail ao usuário logado informando que o pedido foi cadastrado com
     * sucesso.
     *
     * @param emailUsuarioLogado O endereço de e-mail do usuário logado.
     * @param pedido             O pedido que foi cadastrado.
     */
    private void enviarEmailPedidoCadastrado(String emailUsuarioLogado, Pedido pedido) {
        // Cria o assunto do e-mail
        String assunto = "Pedido Cadastrado";

        // Constrói a mensagem do e-mail com os detalhes do pedido
        String mensagem = String
                .format("O seu pedido foi cadastrado com sucesso!\nDetalhes do Pedido:\n" + pedido.toString());

        // Chama o serviço de e-mail para enviar a mensagem
        emailService.sendEmail(emailUsuarioLogado, assunto, mensagem);
    }

    // Busca um Pedido pelo ID e retorna o pedido encontrado, ou null se não
    // existir.

    public PedidoDto busca(int id) {
        // return pRepository.findById(id).orElse((new Pedido()));

        Pedido pedido = pRepository.findById(id).orElse(new Pedido());

        return pedido != null ? new PedidoDto(pedido) : null;

    }

    public void excluir(int id) {
        pRepository.deleteById(id);
    }

    public boolean updatePedidoByItem(int quantidade, Pedido updatePedido) {
        // Procura um pedido pelo item na base de dados.
        Optional<Pedido> existingPedidoOptional = pRepository.findByQuantidade(quantidade);

        if (existingPedidoOptional.isPresent()) {
            // Se um pedido com o item fornecido for encontrado, atualiza suas informações.

            // Obtém o pedido existente a partir do Optional.
            Pedido existingPedido = existingPedidoOptional.get();

            // Atualiza os campos do pedido existente com as informações do pedido
            // atualizado.
            existingPedido.setData(updatePedido.getData());

            // Salva as alterações na base de dados.
            pRepository.save(existingPedido);

            // Retorna verdadeiro para indicar que a atualização foi bem-sucedida.
            return true;
        } else {
            // Se nenhum pedido com o item fornecido for encontrado, retorna falso.
            return false;
        }

    }
}
