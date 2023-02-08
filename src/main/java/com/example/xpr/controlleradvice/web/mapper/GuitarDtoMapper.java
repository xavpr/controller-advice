package com.example.xpr.controlleradvice.web.mapper;

import com.example.xpr.controlleradvice.domain.model.Guitar;
import com.example.xpr.controlleradvice.web.dto.GuitarDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuitarDtoMapper {

    List<GuitarDto> toDtos(List<Guitar> models);


}
