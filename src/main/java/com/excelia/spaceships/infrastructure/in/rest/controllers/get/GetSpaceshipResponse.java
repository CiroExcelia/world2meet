package com.excelia.spaceships.infrastructure.in.rest.controllers.get;

import java.util.UUID;

public record GetSpaceshipResponse(
    UUID id,
    String name,
    String captainName,
    Double length,
    Integer maxSpeed,
    String appearsIn
) {

}
