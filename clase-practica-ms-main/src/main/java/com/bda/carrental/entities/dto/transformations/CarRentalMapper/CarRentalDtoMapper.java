package com.bda.carrental.entities.dto.transformations.CarRentalMapper;

import com.bda.carrental.entities.CarRental;
import com.bda.carrental.entities.dto.CarRentalDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CarRentalDtoMapper implements Function<CarRental, CarRentalDto> {
    @Override
    public CarRentalDto apply(CarRental carRental) {
        return new CarRentalDto(
                carRental.getId(),
                carRental.getRentalDate(),
                carRental.getReturnedDate(),
                carRental.getPayed()
        );
    }
}
