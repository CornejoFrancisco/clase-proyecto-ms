package com.bda.carrental.services.CarRentalService;

import com.bda.carrental.entities.CarRental;
import com.bda.carrental.entities.dto.CarRentalDto;
import com.bda.carrental.entities.dto.transformations.CarRentalMapper.CarRentalDtoMapper;
import com.bda.carrental.entities.dto.transformations.CarRentalMapper.CarRentalMapper;
import com.bda.carrental.repositories.CarRentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CarRentalServiceImpl implements CarRentalService{
    private final CarRentalRepository carRentalRepository;
    private final CarRentalDtoMapper carRentalDtoMapper;

    private final CarRentalMapper carRentalMapper;

    public CarRentalServiceImpl(CarRentalRepository carRentalRepository,
                                CarRentalDtoMapper carRentalDtoMapper,
                                CarRentalMapper carRentalMapper) {
        this.carRentalRepository = carRentalRepository;
        this.carRentalDtoMapper = carRentalDtoMapper;
        this.carRentalMapper = carRentalMapper;
    }

    @Override
    public void add(CarRentalDto entity) {
        CarRental carRental = new CarRental();
        carRental.setRentalDate(entity.getRentalDate());
        carRental.setId(entity.getId());
        carRental.setPayed(entity.getPayed());
        carRental.setReturnedDate(entity.getReturnedDate());
        carRentalRepository.save(carRental);

    }

    @Override
    public CarRentalDto getById(Long id) {
        Optional<CarRental> value = carRentalRepository.findById(id);
        return value
                .map(carRentalDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<CarRentalDto> getAll() {
        List<CarRental> values = carRentalRepository.findAll();
        return values
                .stream()
                .map(carRentalDtoMapper)
                .toList();
    }

    @Override
    public CarRentalDto delete(Long id) {
        Optional<CarRental> optionalCarRental = carRentalRepository.findById(id);
        optionalCarRental.ifPresent(carRentalRepository::delete);
        return optionalCarRental
                .map(carRentalDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(CarRentalDto entity) {
        Optional<CarRental> carRental = Stream.of(entity).map(carRentalMapper).findFirst();
        carRental.ifPresent(carRentalRepository::save);
    }
}
