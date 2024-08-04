package com.example.demo.service;


import com.example.demo.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> findAll();

    Categoria findById(Long id);

    Categoria save(Categoria categoria);

    void deleteById(Long id);
}
