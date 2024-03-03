package com.burcu.mapper;

import com.burcu.dto.request.CarSaveRequestDto;
import com.burcu.dto.request.ModelSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    ModelSaveRequestDto fromCarDtoToModelDto(final CarSaveRequestDto dto);
}
