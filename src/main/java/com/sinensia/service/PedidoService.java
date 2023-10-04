package com.sinensia.service;

import java.util.List;

import com.sinensia.model.Pedido;

/**
 * Interfaz que implementaremos en nuestro @Service
 * 
 * @see com.sinensia.service.PedidoServiceImpl
 */
public interface PedidoService {

	List<Pedido> getAll();

	List<Pedido> save(String nombre, int unidades);

}
