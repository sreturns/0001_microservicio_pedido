package com.sinensia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.model.Pedido;

/**
 * Implementamos la especificacion de JpaRepository
 * 
 * @see com.sinensia.service.PedidoServiceImpl
 */
public interface PedidoDao extends JpaRepository<Pedido, Integer> {

}
