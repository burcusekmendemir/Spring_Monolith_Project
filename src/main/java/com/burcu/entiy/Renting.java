package com.burcu.entiy;

import com.burcu.utility.enums.RentingStatus;
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
@Table(name = "tbl_renting")
public class Renting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long carId;
    private Long userId;
    private String startDate;
    private String endDate;
    private Double price;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private RentingStatus rentingStatus=RentingStatus.PASSIVE;


}
