package com.cible.backend_cible.controller.task;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cible.backend_cible.model.task.Priority;
import com.cible.backend_cible.service.task.PrioritySERVICE;

import tools.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class PriorityControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PrioritySERVICE prioritySERVICE;

    @InjectMocks
    private PriorityController priorityController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(priorityController).build();
    }

    @Test
    void testGetAllPriorities() throws Exception {
        Priority p1 = new Priority();
        p1.setId(1);
        p1.setName("High");

        Priority p2 = new Priority();
        p2.setId(2);
        p2.setName("Low");

        when(prioritySERVICE.getAllPriorities()).thenReturn(List.of(p1, p2));

        mockMvc.perform(get("/api/priorities/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("High"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Low"));
    }

    @Test
    void testGetPriorityById_Found() throws Exception {
        Priority p = new Priority();
        p.setId(1);
        p.setName("High");

        when(prioritySERVICE.getPriorityById(1)).thenReturn(Optional.of(p));

        mockMvc.perform(get("/api/priorities/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("High"));
    }

    @Test
    void testGetPriorityById_NotFound() throws Exception {
        when(prioritySERVICE.getPriorityById(999)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/priorities/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreatePriority() throws Exception {
        Priority p = new Priority();
        p.setId(1);
        p.setName("High");

        when(prioritySERVICE.createPriority(p)).thenReturn(p);

        mockMvc.perform(post("/api/priorities/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(p)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("High"));
    }

    @Test
    void testDeletePriority() throws Exception {
        doNothing().when(prioritySERVICE).deletePriority(1);

        mockMvc.perform(delete("/api/priorities/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
