package com.excelia.spaceships.infrastructure.out.persistence.mappers;

import com.excelia.spaceships.domain.entities.Spaceship;
import com.excelia.spaceships.infrastructure.out.persistence.model.SpaceshipPostgreModel;
import org.springframework.stereotype.Component;

@Component
public class SpaceshipPostgreMapper {

    public SpaceshipPostgreModel toPostgreModel(Spaceship source) {

        return SpaceshipPostgreModel.builder()
            .id(source.getId())
            .name(source.getName())
            .captainName(source.getCaptainName())
            .length(source.getLength())
            .maxSpeed(source.getMaxSpeed())
            .appearsIn(source.getAppearsIn())
            .build();
    }

    public Spaceship toDomainEntity(SpaceshipPostgreModel source) {

        return Spaceship.builder()
            .id(source.getId())
            .name(source.getName())
            .captainName(source.getCaptainName())
            .length(source.getLength())
            .maxSpeed(source.getMaxSpeed())
            .appearsIn(source.getAppearsIn())
            .build();
    }
}
