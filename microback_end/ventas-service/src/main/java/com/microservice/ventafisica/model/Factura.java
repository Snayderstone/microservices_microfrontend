package com.microservice.ventafisica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Factura  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "modo_pago_id")
    private ModoPago modoPago;

    @OneToMany(mappedBy = "factura")
    @JsonIgnoreProperties("factura")
    private List<Detalle> detalles;

    private Integer idCustomer;

}
