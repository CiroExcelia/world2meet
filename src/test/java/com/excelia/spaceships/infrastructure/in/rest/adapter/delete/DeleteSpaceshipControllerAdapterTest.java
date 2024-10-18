package com.excelia.spaceships.infrastructure.in.rest.adapter.delete;

import com.excelia.spaceships.application.exceptions.SpaceshipNotFoundException;
import com.excelia.spaceships.application.ports.in.DeleteSpaceshipPort;
import com.excelia.spaceships.infrastructure.in.rest.adapter.ControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.UUID;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {DeleteSpaceshipControllerAdapter.class})
class DeleteSpaceshipControllerAdapterTest extends ControllerTest {

    @MockBean
    private DeleteSpaceshipPort deleteSpaceship;

    private static final String DELETE_SPACESHIP_URI = "/spaceships/{spaceship-id}";

    @Test
    void given_ValidDeleteSpaceshipRequest_when_EndpointIsInvoked_then_ResponseIsNoContent() throws Exception {

        mockMvc.perform(delete(DELETE_SPACESHIP_URI, aValidSpaceshipId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void given_InvalidDeleteSpaceshipRequest_when_EndpointIsInvoked_then_ResponseIsBadRequest() throws Exception {

        mockMvc.perform(delete(DELETE_SPACESHIP_URI, anInvalidSpaceshipId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void given_InvalidDeleteSpaceshipRequest_when_EndpointIsInvoked_then_ResponseIsNotFound() throws Exception {

        doThrow(new SpaceshipNotFoundException()).when(deleteSpaceship).delete(aNonExistentSpaceshipId());

        mockMvc.perform(delete(DELETE_SPACESHIP_URI, aNonExistentSpaceshipId())
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