package com.sinensia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getAll() {
		List<Pedido> pedidos = service.getAll();
		return (pedidos != null) ? ResponseEntity.ok(pedidos)
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay pedidos");
	}

	/**
	 * 
	 * @param nombre
	 * @param unidades
	 * @return List<Pedido>
	 */
	@PostMapping(value = "pedido/{nombre}/{u}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@PathVariable("nombre") String nombre, @PathVariable("u") int unidades) {
		try {
			if (nombre.isEmpty() || unidades <= 0) {
				throw new IllegalArgumentException("Parámetros incorrectos");
			}

			List<Pedido> pedidos = service.save(nombre, unidades);

			return ResponseEntity.ok(pedidos);

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parámetros incorrectos");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
		}
	}
}
