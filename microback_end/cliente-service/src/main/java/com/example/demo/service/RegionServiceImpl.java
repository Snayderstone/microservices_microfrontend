package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RegionServiceImpl implements  RegionService{

    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<Region> findRegionAll() {
        return regionRepository.findAll();
    }

//    @Override
//    public List<Region> findRegionByCustomer(Customer customer) {
//        return regionRepository.findByCustomer(customer);
//    }

    @Override
    public Region createRegion(Region region) {
    Region regionDB= regionRepository.save(region);
//        if (regionDB != null) {
//            return  regionDB;
//        }
//        regionDB = regionRepository.save(region);
        return  regionDB;
    }

    @Override
    public Region updateRegion(Region region) {

        Region regionDB = getRegion(region.getId());
        if (regionDB == null){
            return  null;
        }
        regionDB.setName(region.getName());
        return  regionRepository.save(region);
    }

    @Override
    public Region deleteRegion(Region region) {
        Region regionDB= getRegion(region.getId());
        if (regionDB == null) {
            return  null;
        }
        return  regionRepository.save(region);
    }

    @Override
    public Region getRegion(Long id) {
        return regionRepository.findById(id).orElse(null);
    }
}
