package com.burcu.repository;

import com.burcu.dto.response.RentingStatusResponseDto;
import com.burcu.entiy.Renting;
import com.burcu.utility.enums.RentingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentingRepository extends JpaRepository<Renting,Long> {


    List<Renting> findAllByCarIdAndEndDateAfterAndStartDateBefore(Long id, String startDate, String endDate);

    List<Renting> findAllByCarId(Long carId);


}
