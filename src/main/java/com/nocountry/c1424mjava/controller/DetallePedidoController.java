package com.nocountry.c1424mjava.controller;

import com.nocountry.c1424mjava.model.DetallePedido;
import com.nocountry.c1424mjava.service.DetallePedidoService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detallepedido")
public class DetallePedidoController {
    
    private final DetallePedidoService detallePedidoService;
    
    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }
    
    @GetMapping("producto/{id}")
    public String getDetallePedido(@PathVariable int id, ModelMap model) {
        DetallePedido detallePedido = detallePedidoService.getDetallePedido(id);
        model.addAttribute("Detalle", detallePedido);
        return "detalle_pedido";
    }
    
    @GetMapping("/detalles_pedidos.html")
    public String getAllDetallePedido(ModelMap model) {
        List<DetallePedido> detallePedido = detallePedidoService.getAllDetallePedido();
        model.addAttribute("Detalle Pedido", detallePedido);
        return "detalles_pedidos";
    }
    
    @PostMapping("/guardarDetallePedido")
    public ResponseEntity<String> guardarDetallePedido(@RequestBody DetallePedido detallePedido) {
        detallePedidoService.save(detallePedido);
        return ResponseEntity.ok("Detalle del pedido guardado exitosamente.");
    }
    
    
}
