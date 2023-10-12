package com.bda.carrental.entities.dto.transformations.CarRentalMapper;

import com.bda.carrental.entities.CarRental;
import com.bda.carrental.entities.dto.CarRentalDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;

@Service
public class CarRentalMapper implements Function<CarRentalDto, CarRental> {
    @Override
    public CarRental apply(CarRentalDto carRentalDto) {
        return new CarRental(
                carRentalDto.getId(),
                carRentalDto.getRentalDate(),
                carRentalDto.getReturnedDate(),
                carRentalDto.getPayed());
    }
}
