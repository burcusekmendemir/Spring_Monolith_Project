package com.burcu.dto.response;

import com.burcu.utility.enums.CarStatus;
import com.burcu.utility.enums.Colour;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarSaveResponseDto {


    private String plateNumber;
    private String modelName;
    private String brandName;
    @Enumerated(EnumType.STRING)
    private Colour colour;
    private String year;
    private Double price;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private CarStatus carStatus= CarStatus.NOT_RENTED;
}
