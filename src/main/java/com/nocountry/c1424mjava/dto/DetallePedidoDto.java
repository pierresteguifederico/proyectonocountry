package com.nocountry.c1424mjava.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetallePedidoDto {
    
    @NotBlank
    private Integer fk_id_pedido;
    @NotBlank
    private Integer fk_id_producto;
    @NotBlank
    private Integer cantidad;
    @NotBlank
    private double precioTotal;
    @NotBlank
    private double precio_envio;
    
}
