package com.example.xpr.controlleradvice.web.controller;

import com.example.xpr.controlleradvice.domain.service.GuitarService;
import com.example.xpr.controlleradvice.web.dto.CreateGuitarRequest;
import com.example.xpr.controlleradvice.web.dto.GuitarDto;
import com.example.xpr.controlleradvice.web.mapper.GuitarDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("guitar")
@RestController
@AllArgsConstructor
public class GuitarController implements GuitarApi {

    private final GuitarService service;
    private final GuitarDtoMapper mapper;


    @Override
    @GetMapping
    public List<GuitarDto> getAll() {
        return mapper.toDtos(service.findAll());
    }

    @Override
    @PostMapping
    public GuitarDto create(@Valid @RequestBody final CreateGuitarRequest request) {
        //Not implemented, as it is not the purpose of the project
        return GuitarDto.builder().build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable final Long id) {
        service.delete(id);//will throw and exception if there's an issue
        return ResponseEntity.ok().build();
    }
}
