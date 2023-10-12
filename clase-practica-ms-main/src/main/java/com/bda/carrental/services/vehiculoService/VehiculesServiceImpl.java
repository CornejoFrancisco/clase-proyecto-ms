package com.bda.carrental.services.vehiculoService;

import com.bda.carrental.entities.Vehicle;
import com.bda.carrental.entities.dto.VehicleDto;
import com.bda.carrental.entities.dto.transformations.VehiculoMapper.VehicleDtoMapper;
import com.bda.carrental.entities.dto.transformations.VehiculoMapper.VehicleMapper;
import com.bda.carrental.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class VehiculesServiceImpl implements VehiculesService{
    private final VehicleRepository vehicleRepository;
    private final VehicleDtoMapper vehicleDtoMapper;

    private final VehicleMapper vehicleMapper;

    public VehiculesServiceImpl(VehicleRepository vehicleRepository,
                                VehicleDtoMapper vehicleDtoMapper,
                                VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleDtoMapper = vehicleDtoMapper;
        this.vehicleMapper = vehicleMapper;
    }


    @Override
    public void add(VehicleDto entity) {
        Vehicle vehicle = new Vehicle();
        vehicle.setYearmodel(entity.getYearmodel());
        vehicle.setBrandname(entity.getBrandname());
        vehicle.setCompact(entity.getCompact());
        vehicle.setDrivername(entity.getDirvername());
        vehicle.setCosthour(entity.getCosthour());
        vehicle.setTotalmiles(entity.getTotalmiles());
        vehicleRepository.save(vehicle);
    }

    @Override
    public VehicleDto getById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle
                .map(vehicleDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<VehicleDto> getAll() {
        List<Vehicle> values = vehicleRepository.findAll();
        return values
                .stream()
                .map(vehicleDtoMapper)
                .toList();
    }

    @Override
    public VehicleDto delete(Long id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository
                .findById(id);
        optionalVehicle.ifPresent(vehicleRepository::delete);
        return optionalVehicle
                .map(vehicleDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(VehicleDto entity) {
        Optional<Vehicle> vehicle = Stream.of(entity)
                .map(vehicleMapper)
                .findFirst();
        vehicle.ifPresent(vehicleRepository::save);
    }
}
