package com.bda.carrental.controllers;


import com.bda.carrental.entities.Payments;
import com.bda.carrental.entities.dto.PaymentsDto;
import com.bda.carrental.services.PaymentsService.PaymentsService;
import org.apache.coyote.http11.filters.VoidOutputFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentsController {

    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService)
            {
                this.paymentsService = paymentsService ;
            }

    @GetMapping
    public ResponseEntity<List<PaymentsDto>> getAll(){
        List<PaymentsDto> values = paymentsService.getAll();
            return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentsDto> getById(@PathVariable("id") Long id) {
        PaymentsDto value = paymentsService.getById(id);
        return ResponseEntity.ok(value);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        paymentsService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PaymentsDto entity) {
        paymentsService.update(entity);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody PaymentsDto entity) {
        paymentsService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
