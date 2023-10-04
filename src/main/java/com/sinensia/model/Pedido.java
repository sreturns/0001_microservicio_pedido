package com.sinensia.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Mapeamos la clase Pedido con la tabla pedidos
 *
 * @see com.sinensia.service.PedidoService
 * @see com.sinensia.service.PedidoServiceImpl
 */
@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	private int codigoProducto;
	private int unidades;
	private double total;
	private Date fecha;

	public Pedido() {
	}

	/**
	 * 
	 * @param codigoProducto
	 * @param unidades
	 * @param total
	 * @param date
	 */
	public Pedido(int codigoProducto, int unidades, double total, Date date) {
		this.codigoProducto = codigoProducto;
		this.unidades = unidades;
		this.total = total;
		this.fecha = date;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
