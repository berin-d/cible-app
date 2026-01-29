package com.cible.backend_cible.controller.task;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.cible.backend_cible.model.task.Status;
import com.cible.backend_cible.service.task.StatusSERVICE;

import tools.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class StatusControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StatusSERVICE statusSERVICE;

    @InjectMocks
    private StatusController statusController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(statusController).build();
    }

    @Test
    void testGetAllStatuses() throws Exception {
        Status s1 = new Status();
        s1.setId(1);
        s1.setName("Open");

        Status s2 = new Status();
        s2.setId(2);
        s2.setName("Closed");

        when(statusSERVICE.getAllStatus()).thenReturn(List.of(s1, s2));

        mockMvc.perform(get("/api/statuses/all"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].id").value(1))
               .andExpect(jsonPath("$[0].name").value("Open"))
               .andExpect(jsonPath("$[1].id").value(2))
               .andExpect(jsonPath("$[1].name").value("Closed"));
    }

    @Test
    void testGetStatusById_Found() throws Exception {
        Status s = new Status();
        s.setId(1);
        s.setName("Open");

        when(statusSERVICE.getStatusById(1)).thenReturn(Optional.of(s));

        mockMvc.perform(get("/api/statuses/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1))
               .andExpect(jsonPath("$.name").value("Open"));
    }

    @Test
    void testGetStatusById_NotFound() throws Exception {
        when(statusSERVICE.getStatusById(999)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/statuses/999"))
               .andExpect(status().isNotFound());
    }

    @Test
    void testCreateStatus() throws Exception {
        Status s = new Status();
        s.setId(1);
        s.setName("In Progress");

        when(statusSERVICE.createStatus(s)).thenReturn(s);

        mockMvc.perform(post("/api/statuses/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(s)))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1))
               .andExpect(jsonPath("$.name").value("In Progress"));
    }

    @Test
    void testDeleteStatus() throws Exception {
        when(statusSERVICE.deleteStatus(1)).thenReturn(true);

        mockMvc.perform(delete("/api/statuses/1"))
               .andExpect(status().isNoContent()); 
    }
}
