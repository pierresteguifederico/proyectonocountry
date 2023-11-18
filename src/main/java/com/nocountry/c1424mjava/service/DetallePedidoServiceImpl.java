package com.nocountry.c1424mjava.service;

import com.nocountry.c1424mjava.model.DetallePedido;
import com.nocountry.c1424mjava.repository.DetallePedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
    
    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public DetallePedido getDetallePedido(int id) {
        Optional<DetallePedido> optionalDetalle = detallePedidoRepository.findById(id);
        return optionalDetalle.orElse(null);
    }

    @Override
    public List<DetallePedido> getAllDetallePedido() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public DetallePedido save(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }
    
    
}
