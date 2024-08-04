package com.example.demo.controller;



import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoriaController {


    @Autowired
    private CategoryService categoriaService;

    @GetMapping
    public List<Category> getAllCategorias() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoriaById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public Category createCategoria(@RequestBody Category categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/{id}")
    public Category updateCategoria(@PathVariable Long id, @RequestBody Category categoria) {
        categoria.setId(id);
        return categoriaService.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
    }


}
