package com.bda.carrental.controllers;

import com.bda.carrental.entities.dto.ClientCompanyDto;
import com.bda.carrental.entities.dto.ClientDto;
import com.bda.carrental.services.ClientService.ClientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClienteController {
    private final ClientService clientService;

    public ClienteController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll() {
        List<ClientDto> values = clientService.getAll();
        return ResponseEntity.ok(values);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable("id") Long id) {
        ClientDto value = clientService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody ClientDto entity) {
        clientService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto entity) {
        clientService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto entity, @PathVariable("id") Long id) {
        ClientDto value = clientService.getById(id);
        if (value == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        value.setSex(entity.getSex());
        value.setFirstName(entity.getFirstName());
        value.setLastName(entity.getLastName());
        value.setBirthDate(entity.getBirthDate());
        clientService.update(value);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDto> delete(@PathVariable("id") Long id) {
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
