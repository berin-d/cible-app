package com.cible.backend_cible.controller.task;

import com.cible.backend_cible.controller.goal.GoalController;
import com.cible.backend_cible.model.dtos.goal.GoalDTO;
import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.service.goal.GoalSERVICE;
import com.cible.backend_cible.service.task.UserSERVICE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class GoalControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GoalSERVICE goalSERVICE;

    @Mock
    private UserSERVICE userSERVICE;

    @InjectMocks
    private GoalController taskGroupController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskGroupController).build();
        objectMapper = new ObjectMapper();
    }


@Test
void testGetAllTaskGroups() throws Exception {
    GoalDTO g1 = new GoalDTO(1, "Groupe 1", 1, List.of());
    GoalDTO g2 = new GoalDTO(2, "Groupe 2", 1, List.of());

    when(goalSERVICE.getAllTaskGroups()).thenReturn(List.of(g1, g2));
    
    mockMvc.perform(get("/api/task-groups/all"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[1].id").value(2));
}


    @Test
    void testGetGroupById_Found() throws Exception {
        Goal group = new Goal();
        group.setId(1);

        when(goalSERVICE.getGroupByIdOptional(1)).thenReturn(Optional.of(group));
    
        mockMvc.perform(get("/api/task-groups/1")
                        .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1));
    }
    


    @Test
    void testGetGroupById_NotFound() throws Exception {
        when(goalSERVICE.getGroupByIdOptional(999)).thenReturn(Optional.empty());
    
        mockMvc.perform(get("/api/task-groups/999")
                        .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isNotFound());
    }
    


    @Test
    void testCreateGroup() throws Exception {
        Goal group = new Goal();
        group.setId(1);

        when(goalSERVICE.createGroup(group)).thenReturn(group);

        mockMvc.perform(post("/api/task-groups/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(group)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }


    @Test
    void testDeleteGroup() throws Exception {
        when(goalSERVICE.existsById(1)).thenReturn(true);
        doNothing().when(goalSERVICE).deleteGroup(1);
    
        mockMvc.perform(delete("/api/task-groups/1"))
               .andExpect(status().isNoContent());
    }
    
}