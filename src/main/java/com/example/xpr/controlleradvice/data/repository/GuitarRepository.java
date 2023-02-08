package com.example.xpr.controlleradvice.data.repository;

import com.example.xpr.controlleradvice.data.entity.GuitarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuitarRepository extends JpaRepository<GuitarEntity, Long> {
}
