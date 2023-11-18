package com.nocountry.c1424mjava.service;

import com.nocountry.c1424mjava.dto.ProductoDto;
import com.nocountry.c1424mjava.model.Producto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductoService {
    Producto createProducto(ProductoDto productoDTO, MultipartFile imagen) throws IOException;
    void deleteProducto(int id);
    Producto updateProducto(int id, ProductoDto productoDTO, MultipartFile imagen) throws IOException;
    Producto getProducto(int id);
    List<Producto> getAllProductos();
}
