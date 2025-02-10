package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private List<Map<String, Object>> productos = new ArrayList<>(Arrays.asList(
            Map.of("id", 1, "nombre", "Celular", "precio", 500),
            Map.of("id", 2, "nombre", "Laptop", "precio", 1000)
    ));

    @GetMapping
    public ResponseEntity<?> obtenerProductos() {
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable int id) {
        return productos.stream()
                .filter(p -> (int) p.get("id") == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Map<String, Object> nuevoProducto) {
        if (!nuevoProducto.containsKey("id") || !nuevoProducto.containsKey("nombre") || !nuevoProducto.containsKey("precio")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos incompletos.");
        }
        productos.add(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
}
