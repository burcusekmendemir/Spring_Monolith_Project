package com.burcu.service;

import com.burcu.dto.request.RentingSaveRequestDto;
import com.burcu.dto.response.RentingStatusResponseDto;
import com.burcu.entiy.Car;
import com.burcu.entiy.Renting;
import com.burcu.entiy.User;
import com.burcu.mapper.RentingMapper;
import com.burcu.repository.RentingRepository;
import com.burcu.utility.enums.CarStatus;
import com.burcu.utility.enums.RentingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentingService {

    private final RentingRepository rentingRepository;
    private final CarService carService;
    private final UserService userService;

    public Renting save(RentingSaveRequestDto dto) {
        Optional<Car> car=carService.findByCarId(dto.getCarId());
        Optional<User> user=userService.findByUserName(dto.getUserName());

        List<Renting> rentingList = rentingRepository.findAllByCarIdAndEndDateAfterAndStartDateBefore(car.get().getId(), dto.getStartDate(), dto.getEndDate());

        if (!rentingList.isEmpty()) {
            throw new RuntimeException("There is an active rent for the specified car and dates");
        }

        Renting renting=RentingMapper.INSTANCE.fromRentingSaveRequestDtoToRenting(dto);
        renting.setCarId(car.get().getId());
        renting.setUserId(user.get().getId());
        renting.setRentingStatus(RentingStatus.ACTIVE);

        car.get().setCarStatus(CarStatus.RENTED);
        carService.update(car.get());

        return rentingRepository.save(renting);
    }

    public List<Renting> findRentingsByCarId(Long carId) {
        return rentingRepository.findAllByCarId(carId);
    }





}
