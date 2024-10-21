package com.excelia.spaceships.application.usecases;

import com.excelia.spaceships.application.mappers.CreateSpaceshipMapper;
import com.excelia.spaceships.domain.commands.CreateSpaceshipCommand;
import com.excelia.spaceships.domain.events.CreateSpaceshipEvent;
import com.excelia.spaceships.domain.ports.in.CreateSpaceshipPort;
import com.excelia.spaceships.domain.ports.out.SpaceshipRepositoryPort;
import com.excelia.spaceships.infrastructure.out.messaging.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSpaceship implements CreateSpaceshipPort {

    // TODO: Review
    private final SpaceshipRepositoryPort repository;
    private final CreateSpaceshipMapper mapper;
    private final EventPublisher eventPublisher;

    @Override
    public void create(CreateSpaceshipCommand command) {
        eventPublisher.publish(CreateSpaceshipEvent.from(command));
    }
}
