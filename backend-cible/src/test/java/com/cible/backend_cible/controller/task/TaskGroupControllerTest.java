package com.cible.backend_cible.controller.task;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
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

import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.service.task.TaskGroupSERVICE;
import com.cible.backend_cible.service.task.UserSERVICE;

import tools.jackson.databind.ObjectMapper;

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
        TaskGroup g1 = new TaskGroup();
        g1.setId(1);

        TaskGroup g2 = new TaskGroup();
        g2.setId(2);

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

        when(taskGroupSERVICE.getGroupById(1)).thenReturn(group);

        mockMvc.perform(get("/api/task-groups/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }


    @Test
    void testGetGroupById_NotFound() throws Exception {
        when(taskGroupSERVICE.getGroupById(999))
                .thenThrow(new RuntimeException("TaskGroup not found"));

        mockMvc.perform(get("/api/task-groups/999"))
                .andExpect(status().isNotFound());
    }



    @Test
    void testGetGroupsByUser() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("Ben");

        TaskGroup g1 = new TaskGroup();
        g1.setId(10);

        TaskGroup g2 = new TaskGroup();
        g2.setId(20);

        lenient().when(userSERVICE.getUserById(1)).thenReturn(Optional.of(user));

        when(taskGroupSERVICE.getGroupsByUser(
            argThat(u -> u.getId() != null && u.getId() == 1)))
        .thenReturn(List.of(g1, g2));

        mockMvc.perform(get("/api/task-groups/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(10))
                .andExpect(jsonPath("$[1].id").value(20));
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
        doNothing().when(taskGroupSERVICE).deleteGroup(1);

        mockMvc.perform(delete("/api/task-groups/1"))
                .andExpect(status().isOk());
    }
}