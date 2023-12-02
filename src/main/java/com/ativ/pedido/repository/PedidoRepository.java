package com.ativ.pedido.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ativ.pedido.entities.Pedido;

/**
 * Um repositório de dados para a entidade Pedido.
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Optional<Pedido> findByQuantidade(int quantidade);

}
