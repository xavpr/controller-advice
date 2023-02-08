package com.example.xpr.controlleradvice.web.controller;

import com.example.xpr.controlleradvice.web.dto.CreateGuitarRequest;
import com.example.xpr.controlleradvice.web.dto.GuitarDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Guitar API")
//@SecurityRequirement(name = "someToken") //to configure a token common to secured api endpoints
public interface GuitarApi {

    @Operation(summary = "Get all guitars in database", description = "get all guitars")
    List<GuitarDto> getAll();

    @Operation(summary = "create a new guitar", description = "create a new guitar. Visibility: public")
    GuitarDto create(CreateGuitarRequest request);

    @Operation(summary = "delete selected guitar", description = "delete guitar by id")
    @Parameters({
            @Parameter(name = "id", in = ParameterIn.PATH, schema = @Schema(type = "long"), description = "The guitar entity id to be deleted")
    })
    ResponseEntity delete(Long id);

}
