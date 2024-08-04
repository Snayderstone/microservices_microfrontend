//package com.example.demo.controller;
//
//
//import com.example.demo.entity.Producto;
//import com.example.demo.service.ProductoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/products")
//public class ProductoController {
//
//    @Autowired
//    private ProductoService productoService;
//
//    @GetMapping
//    public List<Producto> getAllProductos() {
//        return productoService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Producto getProductoById(@PathVariable Long id) {
//        return productoService.findById(id);
//    }
//
//    @PostMapping
//    public Producto createProducto(@RequestBody Producto producto) {
//        return productoService.save(producto);
//    }
//
//    @PutMapping("/{id}")
//    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
//        producto.setIdProducto(id);
//        return productoService.save(producto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProducto(@PathVariable Long id) {
//        productoService.deleteById(id);
//    }
//
//}
