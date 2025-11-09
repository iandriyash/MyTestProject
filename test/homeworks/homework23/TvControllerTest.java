package homeworks.homework23;

import homeworks.homework22.controller.TvController;
import homeworks.homework22.entity.Tv;
import homeworks.homework22.service.TvService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = TvController.class)
class TvControllerTest {

    @Autowired MockMvc mvc;
    @MockBean TvService tvService;

    @Test
    void getAll_ok() throws Exception {
        when(tvService.findAll())
                .thenReturn(List.of(new Tv(), new Tv()));
        mvc.perform(get("/api/tvs"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getById_found() throws Exception {
        var tv = new Tv(1L, "Sony", "X90J", 50, new BigDecimal("69990"), true, null);
        when(tvService.findById(1L)).thenReturn(Optional.of(tv));

        mvc.perform(get("/api/tvs/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("Sony"));
    }
}
