package cavanaugh.m.sean.aws.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class RestApiControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private RestApiController controller;
    @Mock
    private Environment environment;

    @BeforeEach
    public void setUp() {
        mockMvc = standaloneSetup(controller).build();
        when(environment.getActiveProfiles()).thenReturn(new String[]{"Pilot"});
    }

    @Test
    public void restAPIController_Returns200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void helloWorld_ReturnsHelloWorld_WithEnvironment() throws Exception {
        assertEquals("Hello World from profiles: Pilot", controller.helloWorld().getBody());
    }

    @Test
    public void helloWorld_ReturnsHelloWorld_WithMultipleEnvironments() throws Exception {
        when(environment.getActiveProfiles()).thenReturn(new String[]{"Test, Pilot"});
        assertEquals("Hello World from profiles: Test, Pilot", controller.helloWorld().getBody());
    }

}