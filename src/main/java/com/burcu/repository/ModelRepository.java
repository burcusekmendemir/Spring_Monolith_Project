package com.burcu.repository;

import com.burcu.entiy.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model,Long> {
    Optional<Model> findByModelName(String name);
}
