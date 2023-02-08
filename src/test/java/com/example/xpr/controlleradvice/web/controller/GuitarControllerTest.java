package com.example.xpr.controlleradvice.web.controller;

import com.example.xpr.controlleradvice.config.RestExceptionHandler;
import com.example.xpr.controlleradvice.data.repository.GuitarRepository;
import com.example.xpr.controlleradvice.domain.service.GuitarService;
import com.example.xpr.controlleradvice.web.mapper.GuitarDtoMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
@Import({GuitarController.class, RestExceptionHandler.class})
class GuitarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuitarService guitarService;

    @MockBean
    private GuitarRepository guitarRepository;

    @MockBean
    private GuitarDtoMapper guitarDtoMapper;

    @InjectMocks
    private GuitarController controller;

    @Test
    public void whenPostRequestToUsersAndValidGuitar_thenCorrectResponse() throws Exception {
        String guitar = "{\"brand\": \"Gibson\", \"model\" : \"Les Paul\", \"name\" : \"Standard 50\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/guitar")
                        .content(guitar)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenPostRequestToGuitarsAndInvalidGuitar_thenCorrectResponse() throws Exception {
        String guitar = "{\"name\": \"\", \"brand\": \"Gibson\", \"model\" : \"Les Paul\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/guitar")
                        .content(guitar)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is("name: Name may not be empty"))
                );
    }

    @Test
    public void whenPostRequestToGuitarsAndMultipleInvalidFields_thenCorrectResponse() throws Exception {
        String guitar = "{\"name\": \"\", \"brand\": \"Gibson\", \"model\" : \"\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/guitar")
                        .content(guitar)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is("model: Model is mandatory; name: Name may not be empty"))
                );
    }
}