package com.nocountry.c1424mjava.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductoDto {
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private String categoria;
    private int stock;
    private MultipartFile imagen;

}