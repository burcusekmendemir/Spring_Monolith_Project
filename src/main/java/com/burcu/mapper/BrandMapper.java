package com.burcu.mapper;

import com.burcu.dto.request.BrandSaveRequestDto;
import com.burcu.dto.request.CarSaveRequestDto;
import com.burcu.entiy.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrandMapper {

    BrandMapper INSTANCE= Mappers.getMapper(BrandMapper.class);

    BrandSaveRequestDto fromCarDtoToBrandDto(final CarSaveRequestDto dto);
}
