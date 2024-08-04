package com.microservice.ventafisica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Detalle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @Min(value = 1, message = "la cantidad debe al menos 1")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonIgnoreProperties("detalles")
    private Factura factura;

    private Integer idProduct;
}
