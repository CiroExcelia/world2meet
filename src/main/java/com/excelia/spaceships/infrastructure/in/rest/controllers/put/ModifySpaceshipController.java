package com.excelia.spaceships.infrastructure.in.rest.controllers.put;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Spaceships")
@RequestMapping("/spaceships")
public interface ModifySpaceshipController {

    @Operation(summary = "Update a spaceship values")
    @PutMapping(value = "{spaceshipId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ModifySpaceshipResponse> modify(
        @Parameter(example = "123e4567-e89b-12d3-a456-426614174000") @PathVariable UUID spaceshipId,
        @RequestBody ModifySpaceshipRequest request
    );

}
