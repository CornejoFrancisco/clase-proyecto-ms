package com.bda.carrental.entities.dto.transformations.PaymentsMapper;

import com.bda.carrental.entities.Payments;
import com.bda.carrental.entities.dto.PaymentsDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PaymentsDtoMapper implements Function<Payments, PaymentsDto> {
    @Override
    public PaymentsDto apply(Payments payments){
        return new PaymentsDto(
                payments.getId(),
                payments.getPaymentDate(),
                payments.getCarRentalId(),
                payments.getTotalPaid()
        );
    }
}
