package com.burcu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RentingSaveRequestDto {


    private Long carId;
    private String userName;
    private String startDate;
    private String endDate;
    private Double price;

}
