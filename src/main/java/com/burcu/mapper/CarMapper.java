package com.burcu.mapper;

import com.burcu.dto.request.CarSaveRequestDto;
import com.burcu.dto.response.CarSaveResponseDto;
import com.burcu.entiy.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarMapper {

    CarMapper INSTANCE= Mappers.getMapper(CarMapper.class);

    Car fromCarSaveRequestDtoToCar(final CarSaveRequestDto dto);
    CarSaveResponseDto fromCarToCarSaveResponseDto(final Car car);
}
