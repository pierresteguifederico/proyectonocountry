package com.nocountry.c1424mjava.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data @Table(name = "Detalle_pedido")
public class DetallePedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_pedido;
    @Column(name = "id_pedido")
    private Integer fk_id_pedido;
    @Column(name = "id_producto")
    private Integer fk_id_producto;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio_total")
    private double precioTotal;
    @Column(name = "precio_envio")
    private double precio_envio;
    
}
