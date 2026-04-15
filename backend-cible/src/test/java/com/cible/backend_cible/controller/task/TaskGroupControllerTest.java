package com.cible.backend_cible.controller.task;

import com.cible.backend_cible.model.dtos.task.TaskGroupDTO;
import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.service.task.TaskGroupSERVICE;
import com.cible.backend_cible.service.user.UserSERVICE;
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
public class TaskGroupControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TaskGroupSERVICE taskGroupSERVICE;

    @Mock
    private UserSERVICE userSERVICE;

    @InjectMocks
    private TaskGroupController taskGroupController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskGroupController).build();
        objectMapper = new ObjectMapper();
    }


@Test
void testGetAllTaskGroups() throws Exception {
    TaskGroupDTO g1 = new TaskGroupDTO(1, "Groupe 1", 1, List.of());
    TaskGroupDTO g2 = new TaskGroupDTO(2, "Groupe 2", 1, List.of());
    
    when(taskGroupSERVICE.getAllTaskGroups()).thenReturn(List.of(g1, g2));
    
    mockMvc.perform(get("/api/task-groups/all"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[1].id").value(2));
}


    @Test
    void testGetGroupById_Found() throws Exception {
        TaskGroup group = new TaskGroup();
        group.setId(1);
    
        when(taskGroupSERVICE.getGroupByIdOptional(1)).thenReturn(Optional.of(group));
    
        mockMvc.perform(get("/api/task-groups/1")
                        .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1));
    }
    


    @Test
    void testGetGroupById_NotFound() throws Exception {
        when(taskGroupSERVICE.getGroupByIdOptional(999)).thenReturn(Optional.empty());
    
        mockMvc.perform(get("/api/task-groups/999")
                        .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isNotFound());
    }
    


    @Test
    void testCreateGroup() throws Exception {
        TaskGroup group = new TaskGroup();
        group.setId(1);

        when(taskGroupSERVICE.createGroup(group)).thenReturn(group);

        mockMvc.perform(post("/api/task-groups/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(group)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }


    @Test
    void testDeleteGroup() throws Exception {
        when(taskGroupSERVICE.existsById(1)).thenReturn(true);
        doNothing().when(taskGroupSERVICE).deleteGroup(1);
    
        mockMvc.perform(delete("/api/task-groups/1"))
               .andExpect(status().isNoContent());
    }
    
}