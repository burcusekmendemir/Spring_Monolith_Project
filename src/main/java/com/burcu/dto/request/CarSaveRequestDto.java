package com.burcu.dto.request;


import com.burcu.utility.enums.Colour;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CarSaveRequestDto {


    private String plateNumber;
    private String modelName;
    private String brandName;

    @Enumerated(EnumType.STRING)
    private Colour colour;
    private String year;
    private Double price;
}
