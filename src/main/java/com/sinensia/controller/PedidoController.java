package com.sinensia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.model.Pedido;
import com.sinensia.service.PedidoService;

/**
 * El @RestController que utilizamos para acceder a los metodos Http
 * 
 * @author Sergio
 * @see com.sinensia.dao.PedidoDao
 * @see com.sinensia.service.PedidoServiceImpl
 * @see com.sinensia.service.PedidoService
 * @see com.sinensia.model.Pedido
 */
@RestController
public class PedidoController {

	/**
	 * Inyectamos nuestro servicio
	 */
	@Autowired
	private PedidoService service;

	/**
	 * 
	 * @return List<Pedido>
	 */
	@GetMapping(value = "pedido", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> getAll() {
		return service.getAll();
	}

	/**
	 * 
	 * @param nombre
	 * @param unidades
	 * @return List<Pedido>
	 */
	@PostMapping(value = "pedido/{nombre}/{u}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> save(@PathVariable("nombre") String nombre, @PathVariable("u") int unidades) {
		return service.save(nombre, unidades);
	}
}
