package com.bda.carrental.entities.dto.transformations.PaymentsMapper;


import com.bda.carrental.entities.CarRentals;
import com.bda.carrental.entities.Payments;
import com.bda.carrental.entities.dto.PaymentsDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PaymentsMapper implements Function<PaymentsDto, Payments> {
    @Override
    public Payments apply(PaymentsDto paymentsDto) {
        return new Payments(
                        paymentsDto.getId(),
                        paymentsDto.getPaymentDate(),
                paymentsDto.getCarRentalId(),
                paymentsDto.getTotalPaid(),
                new CarRentals());

    }
}
