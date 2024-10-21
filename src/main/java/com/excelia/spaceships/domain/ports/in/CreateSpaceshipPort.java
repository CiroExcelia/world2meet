package com.excelia.spaceships.domain.ports.in;

import com.excelia.spaceships.domain.commands.CreateSpaceshipCommand;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CreateSpaceshipPort {

    @Transactional
    void create(@Valid CreateSpaceshipCommand command);

}
