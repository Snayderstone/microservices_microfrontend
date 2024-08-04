package com.microservice.ventafisica.repo;

import com.microservice.ventafisica.model.Factura;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository <T,ID>  extends GenericRepository<Factura,Long> {


}
