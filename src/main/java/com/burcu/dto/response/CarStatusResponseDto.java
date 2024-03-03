package com.burcu.dto.response;

import com.burcu.utility.enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CarStatusResponseDto {

    private Long id;
    private String plateNumber;
    private CarStatus carStatus;
    private List<RentingStatusResponseDto> rentings;
}
