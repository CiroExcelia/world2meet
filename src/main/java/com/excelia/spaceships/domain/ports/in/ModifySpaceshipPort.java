package com.excelia.spaceships.domain.ports.in;

import com.excelia.spaceships.domain.commands.ModifySpaceshipCommand;
import com.excelia.spaceships.domain.entities.Spaceship;
import java.util.Optional;

public interface ModifySpaceshipPort {

    Optional<Spaceship> modify(ModifySpaceshipCommand command);

}
