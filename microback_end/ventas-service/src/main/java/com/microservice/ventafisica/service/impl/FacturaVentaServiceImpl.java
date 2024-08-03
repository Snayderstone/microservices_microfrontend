package com.microservice.ventafisica.service.impl;

import com.microservice.ventafisica.api.InventarioClient;
import com.microservice.ventafisica.dto.StockDTO;
import com.microservice.ventafisica.model.FacturaVenta;
import com.microservice.ventafisica.repo.IFacturaVentaRepo;
import com.microservice.ventafisica.repo.IGenericRepo;
import com.microservice.ventafisica.service.IFacturaVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaVentaServiceImpl extends CRUDImpl<FacturaVenta, Integer> implements IFacturaVentaService {
    @Autowired
    private IFacturaVentaRepo repo;

    @Autowired
    private InventarioClient inventarioClient;
    @Override
    protected IGenericRepo<FacturaVenta, Integer> getGenericRepo() {
        return repo;
    }

    @Override
    public StockDTO findByProductoAlmacen (String nombreProducto, String nombreAlmacen) {
        return inventarioClient.findByProductoAlmacen(nombreProducto,nombreAlmacen);
    }

    @Override
    public List<StockDTO> findAllStock() {
        return inventarioClient.findAllStock();
    }
}
