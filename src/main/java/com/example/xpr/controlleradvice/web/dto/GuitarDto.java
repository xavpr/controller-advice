package com.example.xpr.controlleradvice.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GuitarDto {
    private Long id;

    private String brand;

    private String model;

    private String name;
}
