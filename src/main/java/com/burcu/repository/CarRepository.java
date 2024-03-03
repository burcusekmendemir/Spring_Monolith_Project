package com.burcu.repository;

import com.burcu.dto.response.CarStatusResponseDto;
import com.burcu.entiy.Car;
import com.burcu.utility.enums.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {


    Optional<Car> findByPlateNumber(String plateNumber);


    List<Car> findAllByOrderByCarStatusAsc();
}
