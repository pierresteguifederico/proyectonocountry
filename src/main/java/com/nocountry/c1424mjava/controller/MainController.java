package com.nocountry.c1424mjava.controller;

import com.nocountry.c1424mjava.model.Producto;
import com.nocountry.c1424mjava.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {


    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String mostrarEnIndex(ModelMap model) {
        List<Producto> productos = productoService.getAllProductos();
        model.addAttribute("Producto", productos);
        return "index";
    }}

