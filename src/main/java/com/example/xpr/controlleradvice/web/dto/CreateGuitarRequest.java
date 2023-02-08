package com.example.xpr.controlleradvice.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateGuitarRequest {

    @NotBlank(message = "Brand may not be empty")
    private String brand;

    @NotBlank(message = "Model is mandatory")
    private String model;

    @NotBlank(message = "Name may not be empty")
    private String name;
}
