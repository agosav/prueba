package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@RestController
public class ProductoController {

    private final List<Map<String, Object>> productos = List.of(
            Map.of("id", 1, "nombre", "Celular", "precio", 500),
            Map.of("id", 2, "nombre", "Laptop", "precio", 1000)
    );

    @GetMapping
    public ResponseEntity<?> obtenerProductos() {
        return ResponseEntity.ok(productos);
    }
}
