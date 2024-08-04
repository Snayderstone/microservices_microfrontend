package com.microservice.ventafisica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private CategorieDTO categoria;
}
