package com.example.xpr.controlleradvice.domain.mapper;

import com.example.xpr.controlleradvice.data.entity.GuitarEntity;
import com.example.xpr.controlleradvice.domain.model.Guitar;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuitarEntityMapper {

    List<Guitar> toModelList(List<GuitarEntity> entities);

}
