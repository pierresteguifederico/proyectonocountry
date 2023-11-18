package com.nocountry.c1424mjava.service;

import com.nocountry.c1424mjava.model.DetallePedido;
import java.util.List;

public interface DetallePedidoService {
    
    DetallePedido getDetallePedido(int id);
    List<DetallePedido> getAllDetallePedido();
    DetallePedido save(DetallePedido detallePedido);
    
}
