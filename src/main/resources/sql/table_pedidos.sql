CREATE TABLE `productos_bd`.`pedidos` (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    codigo_producto INT,
    unidades INT,
    total DOUBLE,
    fecha TIMESTAMP,
    FOREIGN KEY (codigo_producto) REFERENCES productos(codigo_producto)
);