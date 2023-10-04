package com.sinensia.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinensia.dao.PedidoDao;
import com.sinensia.dto.ProductoDTO;
import com.sinensia.model.Pedido;

/**
 * Realizamos todos los metodos implementads de la interfaz, desde el dao
 * accedemos a los CRUD
 * 
 * @see com.sinensia.service.PedidoService
 * @see com.sinensia.controller.PedidoController
 */
@Service
public class PedidoServiceImpl implements PedidoService {

	/**
	 * Inyectamos nuestro repositorio
	 */
	@Autowired
	private PedidoDao dao;

	/**
	 * Inyectamos el template configurado como @Bean en la clase de configuracion
	 */
	@Autowired
	private RestTemplate template;

	private final String URL_CONNECTION = "http://localhost:8080/producto";

	/**
	 *
	 * @return List<Pedido>
	 */
	public List<Pedido> getAll() {
		return dao.findAll();
	}

	/**
	 * 
	 * @param nombre
	 * @param unidades
	 * @return List<Pedido>
	 */
	@Override
	public List<Pedido> save(String nombre, int unidades) {

		List<ProductoDTO> productos = Arrays.asList(template.getForObject(URL_CONNECTION, ProductoDTO[].class));

		ProductoDTO producto = new ProductoDTO();

		Pedido pedido;

		for (ProductoDTO productoDTO : productos) {
			if (productoDTO.getProducto().equalsIgnoreCase(nombre)) {
				producto = productoDTO;
			}
		}

		pedido = new Pedido(producto.getCodigoProducto(), unidades, unidades * producto.getPrecioUnitario(),
				new Date());

		dao.save(pedido);
		if (producto != null) {
			// Actualizar el stock del producto
			int nuevoStock = producto.getStock() - unidades;
			producto.setStock(nuevoStock);

			// Actualizar el producto en el servicio de productos
			template.put(URL_CONNECTION, producto);
		}

		return getAll();

	}
}
