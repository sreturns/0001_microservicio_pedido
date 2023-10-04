package com.sinensia.dto;

import java.util.Objects;

/**
 * Clase que utilizamos para mapear el recurso producto y poder añadirlo a un
 * pedido desde dos microservicios independientes
 * 
 * @see com.sinensia.service.PedidoServiceImpl
 * @see com.sinensia.controller.PedidoController
 */
public class ProductoDTO {

	private int codigoProducto;
	private String producto;
	private double precioUnitario;
	private int stock;

	public ProductoDTO() {
	}

	/**
	 * 
	 * @param codigoProducto
	 * @param precioUnitario
	 * @param stock
	 */
	public ProductoDTO(int codigoProducto, double precioUnitario, int stock) {
		this.codigoProducto = codigoProducto;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoProducto, precioUnitario, producto, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoDTO other = (ProductoDTO) obj;
		return codigoProducto == other.codigoProducto
				&& Double.doubleToLongBits(precioUnitario) == Double.doubleToLongBits(other.precioUnitario)
				&& Objects.equals(producto, other.producto) && stock == other.stock;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
