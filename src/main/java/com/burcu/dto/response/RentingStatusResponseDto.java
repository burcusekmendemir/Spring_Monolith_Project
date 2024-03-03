package com.burcu.dto.response;

import com.burcu.utility.enums.RentingStatus;
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

public class RentingStatusResponseDto {


    private Long userId;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private RentingStatus rentingStatus=RentingStatus.PASSIVE;


}
