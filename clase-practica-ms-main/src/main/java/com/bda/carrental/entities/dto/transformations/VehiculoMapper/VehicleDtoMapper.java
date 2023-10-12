package com.bda.carrental.entities.dto.transformations.VehiculoMapper;

import com.bda.carrental.entities.Vehicle;
import com.bda.carrental.entities.dto.VehicleDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class VehicleDtoMapper implements Function<Vehicle, VehicleDto> {
    @Override
    public VehicleDto apply(Vehicle vehicle){
        return new VehicleDto(
                vehicle.getId(),
                vehicle.getYearmodel(),
                vehicle.getBrandname(),
                vehicle.getCompact(),
                vehicle.getBrandname(),
                vehicle.getCosthour(),
                vehicle.getTotalmiles());
    }
}
