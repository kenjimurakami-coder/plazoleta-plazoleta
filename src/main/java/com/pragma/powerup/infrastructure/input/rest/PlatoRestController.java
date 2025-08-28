package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.application.dto.response.PlatoResponseDto;
import com.pragma.powerup.application.handler.IPlatoHandler;
import com.pragma.powerup.application.mapper.IPlatoResponseMapper;
import com.pragma.powerup.domain.model.PlatoModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/plazoleta/plato")

public class PlatoRestController {
    private final IPlatoHandler platoHandler;
    private final IPlatoResponseMapper platoResponseMapper;

    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })

    @PostMapping
    public ResponseEntity<PlatoResponseDto> savePlato(@RequestBody PlatoRequestDto platoRequestDto) {
        PlatoModel platoModel = platoHandler.savePlato(platoRequestDto);
        PlatoResponseDto platoResponseDto = platoResponseMapper.toResponse(platoModel);
        return new ResponseEntity<>(platoResponseDto, HttpStatus.CREATED);
    }



    @Operation(summary = "Get all objects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PlatoResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<PlatoResponseDto>> getAllPlato() {
        return ResponseEntity.ok(platoHandler.getAllPlato());
    }

    @Operation(summary = "Update a dish")
    @ApiResponse(responseCode = "200", description = "Dish updated", content = @Content)
    @ApiResponse(responseCode = "404", description = "Dish not found", content = @Content)
    @PutMapping("/")
    public ResponseEntity<Void> updatePlato(@RequestBody PlatoRequestDto platoRequestDto) {
        platoHandler.updatePlato(platoRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
