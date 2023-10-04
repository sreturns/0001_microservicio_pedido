
# Proyecto 2 Semana 4 


Este proyecto se basa en el desarrollo de un microservico con Sprinboot.
Desde este proyecto accederemos a nuestro microservico Book.
Con las dependencias de Spring Web, Spring data Jpa, mysql connector, devtools.

Esta aplicación se ha hecho con la intención de ser ampliada a lo largo de las siguientes semanas.


## Authors

- [Sergio](https://www.github.com/sreturns)


## Tech Stack

 Java, SpringBoot, Maven


## API Reference

#### Get all Curso

```
  GET /pedido
```


#### Add Pedido

```
  POST /pedido/{nombre}/{u}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre, unidades`      |  | **Required**. Type String nombre and int unidades
