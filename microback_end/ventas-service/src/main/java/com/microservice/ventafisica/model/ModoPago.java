package com.microservice.ventafisica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModoPago  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModoPago;

    @NotEmpty(message = "El nombre del modo de pago no puede estar vacío")
    private String nombre;
}
