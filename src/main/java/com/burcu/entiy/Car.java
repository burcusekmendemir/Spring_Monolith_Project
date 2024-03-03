package com.burcu.entiy;

import com.burcu.utility.enums.CarStatus;
import com.burcu.utility.enums.Colour;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plateNumber;
    private Long modelId;
    @Enumerated(EnumType.STRING)
    private Colour colour;
    private String year;
    private Double price;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private CarStatus carStatus= CarStatus.NOT_RENTED;

}
