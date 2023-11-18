package com.nocountry.c1424mjava.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nocountry.c1424mjava.dto.ProductoDto;
import com.nocountry.c1424mjava.model.Producto;
import com.nocountry.c1424mjava.repository.ProductoRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public Producto createProducto(ProductoDto productoDTO, MultipartFile imagen) throws IOException {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecioUnitario(productoDTO.getPrecioUnitario());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setStock(productoDTO.getStock());
        producto.setImagen(imagen.getBytes());
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public Producto updateProducto(int id, ProductoDto productoDTO, MultipartFile imagen) throws IOException {
        Optional<Producto> optionalProducto = productoRepository.findById(id);

        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecioUnitario(productoDTO.getPrecioUnitario());
            producto.setCategoria(productoDTO.getCategoria());
            producto.setStock(productoDTO.getStock());

            if (imagen != null && !imagen.isEmpty()) {
                producto.setImagen(imagen.getBytes());
            }

            return productoRepository.save(producto);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto getProducto(int id) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        return optionalProducto.orElse(null);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
}
