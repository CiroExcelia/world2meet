package com.excelia.spaceships.infrastructure.in.rest.mappers;

import com.excelia.spaceships.domain.command.CreateSpaceshipCommand;
import com.excelia.spaceships.domain.entities.Spaceship;
import com.excelia.spaceships.infrastructure.in.rest.controllers.post.CreateSpaceshipRequest;
import com.excelia.spaceships.infrastructure.in.rest.controllers.post.CreateSpaceshipResponse;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class CreateSpaceshipRestMapper {

    public CreateSpaceshipCommand toCommand(CreateSpaceshipRequest source, UUID spaceshipId) {
        return new CreateSpaceshipCommand(
            spaceshipId,
            source.name(),
            source.captainName(),
            source.length(),
            source.maxSpeed(),
            source.appearsIn()
        );
    }

    public CreateSpaceshipResponse toResponse(Spaceship source) {
        return new CreateSpaceshipResponse(
            source.getId(),
            source.getName(),
            source.getCaptainName(),
            source.getLength(),
            source.getMaxSpeed(),
            source.getAppearsIn()
        );
    }
}
