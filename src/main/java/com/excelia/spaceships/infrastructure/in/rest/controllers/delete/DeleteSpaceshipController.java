package com.excelia.spaceships.infrastructure.in.rest.controllers.delete;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Spaceships")
@RequestMapping("/spaceships")
public interface DeleteSpaceshipController {

    @Operation(summary = "Delete a spaceship")
    @DeleteMapping("{spaceshipId}")
    ResponseEntity<Void> delete(
        @Parameter(example = "123e4567-e89b-12d3-a456-426614174000") @PathVariable UUID spaceshipId);

}
