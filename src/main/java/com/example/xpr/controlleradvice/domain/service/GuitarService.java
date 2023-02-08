package com.example.xpr.controlleradvice.domain.service;

import com.example.xpr.controlleradvice.data.repository.GuitarRepository;
import com.example.xpr.controlleradvice.domain.mapper.GuitarEntityMapper;
import com.example.xpr.controlleradvice.domain.model.Guitar;
import com.example.xpr.controlleradvice.domain.validator.DeleteGuitarValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GuitarService {

    private final GuitarRepository guitarRepository;
    private final GuitarEntityMapper mapper;

    private final DeleteGuitarValidator deleteGuitarValidator;

    public List<Guitar> findAll() {
        return mapper.toModelList(guitarRepository.findAll());
    }

    public void delete(Long id) {
        log.info("deleting guitar with id: {}", id);

        deleteGuitarValidator.test(id);

        guitarRepository.delete(guitarRepository.getOne(id));//Not the best way to do that but for this example, it would ne ok

    }

}
