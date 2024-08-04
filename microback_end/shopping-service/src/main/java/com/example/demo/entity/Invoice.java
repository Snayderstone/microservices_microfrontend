package com.example.demo.entity;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tlb_invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_invoice")
    private String numberInvoice;
    private String description;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
    private String state;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItem> items;

    @ManyToOne
    @JoinColumn(name = "page_mode_id")
    private PageMode pageMode;


    @Column(name = "customer_id")
    private Long customerId;

    //Este campo no se registra en la base de datos y s eusa con el cliente feing
    @Transient
    private Customer customer;
    public Invoice(){
        items = new ArrayList<>();
    }

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

}
