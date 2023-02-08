package com.example.xpr.controlleradvice.domain.validator;

import com.example.xpr.controlleradvice.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static com.example.xpr.controlleradvice.exception.ErrorType.GUITAR_ID_NOT_FOUND;
import static java.util.Objects.isNull;

@Component
public class DeleteGuitarValidator implements Predicate<Long> {
    @Override
    public boolean test(Long id) {

        if(isNull(id))
            throw new BadRequestException(GUITAR_ID_NOT_FOUND);

        return true;
    }
}
