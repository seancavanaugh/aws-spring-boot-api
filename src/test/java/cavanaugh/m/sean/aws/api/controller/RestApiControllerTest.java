package cavanaugh.m.sean.aws.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RestApiControllerTest {

    private MockMvc mockMvc;
    private RestApiController controller;

    @BeforeEach
    void setUp() {
        controller = new RestApiController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    public void restAPIController_Returns200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void helloWorld_ReturnsHelloWorld() throws Exception {
        assertEquals("Hello World", controller.helloWorld().getBody());
    }

}