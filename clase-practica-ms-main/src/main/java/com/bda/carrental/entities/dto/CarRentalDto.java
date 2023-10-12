package com.bda.carrental.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CarRentalDto {
    private Integer id;
    private String rentalDate;
    private String returnedDate;
    private Integer payed;
}
