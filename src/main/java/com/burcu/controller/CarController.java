package com.burcu.controller;

import com.burcu.dto.request.CarSaveRequestDto;
import com.burcu.dto.response.CarSaveResponseDto;
import com.burcu.dto.response.CarStatusResponseDto;
import com.burcu.entiy.Car;
import com.burcu.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.burcu.constants.RestApiUrls.*;

@RestController
@RequestMapping(CAR)
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid CarSaveRequestDto dto) {
        carService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Car>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }


    @GetMapping("/status")
    public ResponseEntity<List<CarStatusResponseDto>> findAllCarsByStatus() {
        return ResponseEntity.ok(carService.findAllCarsByStatus());
    }

}
