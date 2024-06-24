package BackEndC2.ClinicaOdontologica;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegracionOdontologosTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRegisterNewOdontologo() throws Exception {
        String newOdontologo = "{"
                + "\"matricula\": \"MP123456\","
                + "\"nombre\": \"Juan\","
                + "\"apellido\": \"Perez\""
                + "}";

        mockMvc.perform(post("/odontologo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newOdontologo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.matricula", is("MP123456")))
                .andExpect(jsonPath("$.nombre", is("Juan")))
                .andExpect(jsonPath("$.apellido", is("Perez")));
    }
}
