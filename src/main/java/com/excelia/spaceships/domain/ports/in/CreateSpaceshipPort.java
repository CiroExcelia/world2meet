package com.excelia.spaceships.domain.ports.in;

import com.excelia.spaceships.domain.command.CreateSpaceshipCommand;
import com.excelia.spaceships.domain.entities.Spaceship;

public interface CreateSpaceshipPort {

    Spaceship create(CreateSpaceshipCommand command);

}
