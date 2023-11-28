package com.ativ.pedido.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ativ.pedido.entities.FormaDePagamento;

@Repository
public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Integer> {
    Optional<FormaDePagamento> findByTipo(String tipo);

}
