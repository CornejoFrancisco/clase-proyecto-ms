package com.bda.carrental.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsDto {
    private long id;
    private String paymentDate;
    private Integer carRentalId;
    private Double totalPaid;
}
