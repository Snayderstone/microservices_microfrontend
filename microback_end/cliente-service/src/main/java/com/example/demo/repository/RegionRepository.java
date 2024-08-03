package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository <Region,Long> {

    //  public List<Region> findByCustomer(Customer customer);
//    public Region findByIdRegion(Long idRegion);
  //  public List<Region> findByName(String name);


}
