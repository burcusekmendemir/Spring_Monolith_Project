package com.burcu.service;

import com.burcu.dto.request.BrandSaveRequestDto;
import com.burcu.entiy.Brand;
import com.burcu.exception.RentACarException;
import com.burcu.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public Brand save(BrandSaveRequestDto dto) {
        Optional<Brand> brandOptional=brandRepository.findByBrandName(dto.getBrandName());
        return brandOptional.orElseGet(() -> brandRepository.save(Brand.builder().brandName(dto.getBrandName()).build()));
    }
}
