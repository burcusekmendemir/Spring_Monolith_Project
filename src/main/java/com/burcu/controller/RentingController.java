package com.burcu.controller;

import com.burcu.dto.request.RentingSaveRequestDto;
import com.burcu.dto.response.RentingStatusResponseDto;
import com.burcu.entiy.Renting;
import com.burcu.service.RentingService;
import com.burcu.utility.enums.RentingStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.burcu.constants.RestApiUrls.*;

@RestController
@RequestMapping(RENTING)
@RequiredArgsConstructor
public class RentingController {
    private final RentingService rentingService;


    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid RentingSaveRequestDto dto){
        rentingService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<Renting>> findRentingsByCarId(@PathVariable Long carId) {
        List<Renting> rentings = rentingService.findRentingsByCarId(carId);
        return ResponseEntity.ok(rentings);
    }

}
