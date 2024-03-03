package com.burcu.service;

import com.burcu.dto.request.CarSaveRequestDto;
import com.burcu.dto.request.ModelSaveRequestDto;
import com.burcu.dto.response.CarSaveResponseDto;
import com.burcu.dto.response.CarStatusResponseDto;
import com.burcu.dto.response.RentingStatusResponseDto;
import com.burcu.entiy.Brand;
import com.burcu.entiy.Car;
import com.burcu.entiy.Model;
import com.burcu.entiy.Renting;
import com.burcu.exception.ErrorType;
import com.burcu.exception.RentACarException;
import com.burcu.mapper.BrandMapper;
import com.burcu.mapper.CarMapper;
import com.burcu.mapper.ModelMapper;
import com.burcu.repository.CarRepository;
import com.burcu.repository.RentingRepository;
import com.burcu.utility.enums.CarStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final BrandService brandService;
    private final ModelService modelService;
    private final RentingRepository rentingRepository;

    public Car save(CarSaveRequestDto dto) {
        Brand brand=brandService.save(BrandMapper.INSTANCE.fromCarDtoToBrandDto(dto));
        ModelSaveRequestDto modelDto= ModelMapper.INSTANCE.fromCarDtoToModelDto(dto);
        modelDto.setBrandId(brand.getId());
        Model model= modelService.save(modelDto);

        Optional<Car> optionalCar=carRepository.findByPlateNumber(dto.getPlateNumber());
        if (optionalCar.isPresent()){
            throw new RentACarException(ErrorType.CAR_ALREADY_EXISTS);
        }
        Car car=CarMapper.INSTANCE.fromCarSaveRequestDtoToCar(dto);
        car.setModelId(model.getId());
        return carRepository.save(car);
    }

    public Optional<Car> findByCarId(Long carId) {
        Optional<Car> optionalCar=carRepository.findById(carId);
        if (optionalCar.isPresent() && optionalCar.get().getCarStatus().equals(CarStatus.NOT_RENTED)){
            return optionalCar;
        }
        throw new RentACarException(ErrorType.CAR_NOT_FOUND);
    }



    public Car update(Car updatedCar) {
        // Güncellenen arabanın mevcut olup olmadığını kontrol eder
        Car existingCar = carRepository.findById(updatedCar.getId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        // Güncellenen arabanın özelliklerini mevcut arabaya kopyalar
        existingCar.setPlateNumber(updatedCar.getPlateNumber());
        existingCar.setModelId(updatedCar.getModelId());
        existingCar.setColour(updatedCar.getColour());
        existingCar.setYear(updatedCar.getYear());
        existingCar.setPrice(updatedCar.getPrice());

        // Veritabanına güncellenmiş arabayı kaydeder
        return carRepository.save(existingCar);
    }



    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public List<CarStatusResponseDto> findAllCarsByStatus() {
        List<Car> cars = carRepository.findAllByOrderByCarStatusAsc();
        return cars.stream()
                .map(this::mapToCarStatusResponseDto)
                .collect(Collectors.toList());
    }

    private CarStatusResponseDto mapToCarStatusResponseDto(Car car) {
        List<Renting> rentings = rentingRepository.findAllByCarId(car.getId());
        List<RentingStatusResponseDto> rentingStatuses = rentings.stream()
                .map(renting -> RentingStatusResponseDto.builder()
                        .userId(renting.getUserId())
                        .rentingStatus(renting.getRentingStatus())
                        .build())
                .collect(Collectors.toList());

        return CarStatusResponseDto.builder()
                .id(car.getId())
                .plateNumber(car.getPlateNumber())
                .carStatus(car.getCarStatus())
                .rentings(rentingStatuses)
                .build();
    }
}
