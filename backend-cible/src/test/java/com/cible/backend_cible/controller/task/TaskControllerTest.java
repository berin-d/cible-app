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

import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.service.task.TaskSERVICE;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {
    
        private MockMvc mockMvc;

        @Mock
        private TaskSERVICE taskSERVICE;

        @InjectMocks
        private TaskController taskController;

        @BeforeEach
        void setup() {
            mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
        }

    

    @Test
    void testGetAllTasks() throws Exception {
        Task t1 = new Task();
        t1.setId(1);
        t1.setTitle("Task 1");

        Task t2 = new Task();
        t2.setId(2);
        t2.setTitle("Task 2");

        when(taskSERVICE.getAllTasks()).thenReturn(List.of(t1, t2));

        mockMvc.perform(get("/api/tasks/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Task 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Task 2"));
    }


    @Test
    void testGetTaskById_Found() throws Exception {
        Task t1 = new Task();
        t1.setId(1);
        t1.setTitle("Important Task");

        when(taskSERVICE.getTaskById(1)).thenReturn(t1);

        mockMvc.perform(get("/api/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Important Task"));
    }


    @Test
    void testGetTaskById_NotFound() throws Exception {
        when(taskSERVICE.getTaskById(999))
                .thenThrow(new RuntimeException("Task not found"));

        mockMvc.perform(get("/api/tasks/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}