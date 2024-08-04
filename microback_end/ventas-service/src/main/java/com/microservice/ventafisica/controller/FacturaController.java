package com.microservice.ventafisica.controller;

import com.microservice.ventafisica.model.Factura;
import com.microservice.ventafisica.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> findAll() {
        return new ResponseEntity<>(facturaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(facturaService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Factura obj) {
        facturaService.save(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Factura> update(@RequestBody Factura obj) {
        Factura response = facturaService.findById(obj.getIdFactura());
        if (response == null) {
            throw new RuntimeException();
        }
        return new ResponseEntity<>(facturaService.update(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Factura obj = facturaService.findById(id);
        if (obj == null) {
            throw new RuntimeException();
        } else {
            facturaService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
