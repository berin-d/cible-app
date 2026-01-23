package com.cible.backend_cible.controller.task;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cible.backend_cible.model.task.Activity;
import com.cible.backend_cible.service.task.ActivitySERVICE;

@ExtendWith(MockitoExtension.class)
public class ActivityControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ActivitySERVICE activitySERVICE;

    @InjectMocks
    private ActivityController activityController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(activityController).build();
    }

    @Test
    void testGetAllActivities() throws Exception {
        Activity a1 = new Activity();
        a1.setId(1);
        Activity a2 = new Activity();
        a2.setId(2);

        when(activitySERVICE.getAllActivities()).thenReturn(List.of(a1, a2));

        mockMvc.perform(get("/api/activities/all")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    void testGetActivitiesByUser() throws Exception {
        Activity a1 = new Activity();
        a1.setId(10);
        Activity a2 = new Activity();
        a2.setId(20);

        when(activitySERVICE.getActivitiesByUserId(1)).thenReturn(List.of(a1, a2));

        mockMvc.perform(get("/api/activities/user/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(10))
            .andExpect(jsonPath("$[1].id").value(20));
    }

    @Test
    void testGetActivitiesById() throws Exception {
        Activity a1 = new Activity();
        a1.setId(100);
        Activity a2 = new Activity();
        a2.setId(200);

        when(activitySERVICE.getActivitiesByUserId(42)).thenReturn(List.of(a1, a2));

        mockMvc.perform(get("/api/activities/42")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(100))
            .andExpect(jsonPath("$[1].id").value(200));
    }
}
