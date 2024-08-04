package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value="/regions")
public class RegionController {
    @Autowired
    RegionService regionService;
    @GetMapping
    public ResponseEntity<List<Region>> listAllRegions(){
        List<Region> regions =  regionService.findRegionAll();
        if (regions.isEmpty()) {
            log.info("No regions found");
            return  ResponseEntity.noContent().build();

        }
        log.info("Listado de Regiones");
        return ResponseEntity.ok(regions);
    }

    // -------------------Retrieve Single Region------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Region> getRegion(@PathVariable("id") long id) {
        log.info("Fetching Region with id {}", id);
        Region region = regionService.getRegion(id);
        if (  null == region) {
            log.error("Customer with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(region);
    }
    // -------------------Create a Region-------------------------------------------

    @PostMapping
    public ResponseEntity<Region> createRegion(@Valid @RequestBody Region region, BindingResult result) {
        log.info("Creating Region : {}", region);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        Region regionDB = regionService.createRegion (region);

        return  ResponseEntity.status( HttpStatus.CREATED).body(regionDB);
    }


    // ------------------- Update a Customer ------------------------------------------------

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateRegion(@PathVariable("id") long id, @RequestBody Region region) {
        log.info("Updating Region with id {}", id);

        Region currentRegion = regionService.getRegion(id);

        if ( null == currentRegion ) {
            log.error("Unable to update. Region with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        region.setId(id);
        currentRegion=regionService.updateRegion(region);
        return  ResponseEntity.ok(currentRegion);
    }

    // ------------------- Delete a Customer-----------------------------------------

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Region> deleteRegion(@PathVariable("id") long id) {
        log.info("Fetching & Deleting Region with id {}", id);

        Region region = regionService.getRegion(id);
        if ( null == region ) {
            log.error("Unable to delete. Region with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        region = regionService.deleteRegion(region);
        return  ResponseEntity.ok(region);
    }


    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
