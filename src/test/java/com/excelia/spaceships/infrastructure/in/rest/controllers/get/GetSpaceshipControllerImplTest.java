package com.excelia.spaceships.infrastructure.in.rest.controllers.get;

import com.excelia.spaceships.domain.ports.in.FindSpaceshipPort;
import com.excelia.spaceships.infrastructure.in.rest.controllers.ControllerTest;
import com.excelia.spaceships.infrastructure.in.rest.mappers.GetSpaceshipRestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;

import java.util.Optional;
import java.util.UUID;

import static com.junit.object_mothers.SpaceshipObjectMother.aSpaceship;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import({GetSpaceshipRestMapper.class})
@WebMvcTest(controllers = {GetSpaceshipControllerImpl.class})
class GetSpaceshipControllerImplTest extends ControllerTest {

    @MockBean
    private FindSpaceshipPort findSpaceship;

    private static final String GET_SPACESHIP_URI = "/spaceships/{spaceship-id}";

    @Test
    void given_ValidGetSpaceshipRequest_when_EndpointIsInvoked_then_ResponseIsOk() throws Exception {

        var validSpaceshipId = aValidSpaceshipId();
        given(findSpaceship.findById(validSpaceshipId)).willReturn(Optional.of(aSpaceship()));

        mockMvc.perform(get(GET_SPACESHIP_URI, validSpaceshipId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void given_ValidGetSpaceshipRequest_when_EndpointIsInvoked_then_ResponseMatchesExpected() throws Exception {

        var validSpaceshipId = aValidSpaceshipId();
        given(findSpaceship.findById(validSpaceshipId)).willReturn(Optional.of(aSpaceship()));

        mockMvc
                .perform(get(GET_SPACESHIP_URI, validSpaceshipId))
                .andExpect(jsonPath("id").isString())
                .andExpect(jsonPath("name").isString())
                .andExpect(jsonPath("captain_name").isString())
                .andExpect(jsonPath("length").isNumber())
                .andExpect(jsonPath("max_speed").isNumber())
                .andExpect(jsonPath("appears_in").isString());
    }

    @Test
    void given_InvalidGetSpaceshipRequest_when_EndpointIsInvoked_then_ResponseIsBadRequest() throws Exception {

        mockMvc.perform(get(GET_SPACESHIP_URI, anInvalidSpaceshipId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void given_InvalidGetSpaceshipRequest_when_EndpointIsInvoked_then_ResponseIsNotFound() throws Exception {

        var nonExistentSpaceshipId = aNonExistentSpaceshipId();
        given(findSpaceship.findById(nonExistentSpaceshipId)).willReturn(Optional.empty());

        mockMvc.perform(get(GET_SPACESHIP_URI, nonExistentSpaceshipId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private static UUID aValidSpaceshipId() {
        return UUID.randomUUID();
    }

    private static String anInvalidSpaceshipId() {
        return "::Invalid UUID value::";
    }

    private static UUID aNonExistentSpaceshipId() {
        return aValidSpaceshipId();
    }
}