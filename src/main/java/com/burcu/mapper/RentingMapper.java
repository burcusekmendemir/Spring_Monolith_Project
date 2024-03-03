package com.burcu.mapper;

import com.burcu.dto.request.RentingSaveRequestDto;
import com.burcu.entiy.Renting;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RentingMapper {

    RentingMapper INSTANCE = Mappers.getMapper(RentingMapper.class);

    Renting fromRentingSaveRequestDtoToRenting(final RentingSaveRequestDto dto);



}
