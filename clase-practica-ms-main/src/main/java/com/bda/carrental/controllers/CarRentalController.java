package com.bda.carrental.controllers;

import com.bda.carrental.entities.dto.CarRentalDto;
import com.bda.carrental.services.CarRentalService.CarRentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrental")
public class CarRentalController {
    private final CarRentalService carRentalService;

    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @GetMapping
    public ResponseEntity<List<CarRentalDto>> getAll() {
        List<CarRentalDto> values = carRentalService.getAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarRentalDto> getById(@PathVariable("id") Long id) {
        CarRentalDto value = carRentalService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CarRentalDto entity) {
        carRentalService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping()
    public ResponseEntity<CarRentalDto> update(@RequestBody CarRentalDto entity) {
        carRentalService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarRentalDto> update(@RequestBody CarRentalDto entity, @PathVariable("id") Long id) {
        CarRentalDto value = carRentalService.getById(id);
        if (value == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
            value.setRentalDate(entity.getRentalDate());
            value.setPayed(entity.getPayed());
            value.setReturnedDate(entity.getReturnedDate());
        carRentalService.update(value);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarRentalDto> delete(@PathVariable("id") Long id) {
        carRentalService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
