package com.microservice.ventafisica.service;

import com.microservice.ventafisica.model.Factura;
import com.microservice.ventafisica.repo.FacturaRepository;
import com.microservice.ventafisica.repo.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends CRUDServiceImp<Factura,Long> implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    protected GenericRepository<Factura, Long> getGenericRepo() {
        return facturaRepository;
    }
}
