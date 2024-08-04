//package com.example.demo.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.*;
//
//@Entity
//@Table(name = "tbl_categories")
//@Data @NoArgsConstructor @AllArgsConstructor @Builder
//public class Categoria {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idCategoria;
//
//    @NotEmpty(message = "El nombre de la categoria no puede estar vacío")
//    private String nombre;
//
//    @NotEmpty(message = "El descripción de la categoria no puede estar vacío")
//    private String descripcion;
//
//}
