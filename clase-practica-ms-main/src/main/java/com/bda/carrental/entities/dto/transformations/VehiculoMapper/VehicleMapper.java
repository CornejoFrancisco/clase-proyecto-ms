package com.bda.carrental.entities.dto.transformations.VehiculoMapper;

import com.bda.carrental.entities.Vehicle;
import com.bda.carrental.entities.dto.VehicleDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;

@Service
public class VehicleMapper implements Function<VehicleDto, Vehicle> {
    @Override
    public Vehicle apply(VehicleDto vehicleDto) {
        return new Vehicle(
                vehicleDto.getId(),
                vehicleDto.getYearmodel(),
                vehicleDto.getBrandname(),
                vehicleDto.getCompact(),
                vehicleDto.getDirvername(),
                vehicleDto.getCosthour(),
                vehicleDto.getTotalmiles());
    }
}
