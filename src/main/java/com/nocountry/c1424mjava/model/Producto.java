package com.nocountry.c1424mjava.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity @Data @Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio_unitario")
    private double precioUnitario;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "stock")
    private int stock;
    @Lob
    @Column(name = "imagen", columnDefinition = "MEDIUMBLOB")
    private byte[] imagen;


}