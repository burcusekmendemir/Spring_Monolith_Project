package com.burcu.service;

import com.burcu.dto.request.ModelSaveRequestDto;
import com.burcu.entiy.Model;
import com.burcu.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;

    public Model save(ModelSaveRequestDto modelDto) {
        Optional<Model> model=modelRepository.findByModelName(modelDto.getModelName());
        return model.orElseGet(() -> modelRepository.save(
                Model.builder()
                .modelName(modelDto.getModelName())
                .brandId(modelDto.getBrandId())
                .build()));
    }
}
