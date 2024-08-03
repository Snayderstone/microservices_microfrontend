package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Region;

import java.util.List;

public interface RegionService {
    public List<Region> findRegionAll();
//    public List<Region> findRegionByCustomer(Customer customer);
    public Region createRegion(Region region);
    public Region updateRegion(Region region);
    public Region deleteRegion(Region region);
    public  Region getRegion(Long id);

}
