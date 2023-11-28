package com.ativ.pedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
    public List<Pedido> lista() {

        return pRepository.findAll();
    }

    // Comentário: Salva o pedido no banco de dados.
    public void salvar(Pedido pedido) {
        // Adicione logs para verificar os dados antes de salvar
        System.out.println("Dados do Pedido recebidos: " + pedido);
        pRepository.save(pedido);
    }

    // Busca um Pedido pelo ID e retorna o pedido encontrado, ou null se não
    // existir.

    public Pedido busca(int id) {
        return pRepository.findById(id).orElse((new Pedido()));

        // uso de null não é recomendado
        // return pRepository.findById(id).orElse((null()));

        // Optional<Pedido> optionalPedido = pRepository.findById(id);
        // return optionalPedido.orElse(null);
    }

    public void excluir(int id) {
        pRepository.deleteById(id);
    }

    public void finalizarPedido(Pedido pedido, String emailUsuarioLogado) {
        try {
            // Lógica para finalizar o pedido...

            // Envio de e-mail ao usuário logado
            String assunto = "Pedido Finalizado";
            String mensagem = "O seu pedido foi finalizado com sucesso!\nDetalhes do Pedido:\n" + pedido.toString();

            emailService.sendEmail(emailUsuarioLogado, assunto, mensagem);
        } catch (Exception e) {
            // Tratar exceções aqui (registre logs, notifique administradores, etc.)
            e.printStackTrace();
        }
    }

    public boolean updatePedidoByItem(String item, Pedido updatePedido) {
        // Procura um pedido pelo item na base de dados.
        Optional<Pedido> existingPedidoOptional = pRepository.findByItem(item);

        if (existingPedidoOptional.isPresent()) {
            // Se um pedido com o item fornecido for encontrado, atualiza suas informações.

            // Obtém o pedido existente a partir do Optional.
            Pedido existingPedido = existingPedidoOptional.get();

            // Atualiza os campos do pedido existente com as informações do pedido
            // atualizado.
            existingPedido.setData(updatePedido.getData());
            existingPedido.setItem(updatePedido.getItem());

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
