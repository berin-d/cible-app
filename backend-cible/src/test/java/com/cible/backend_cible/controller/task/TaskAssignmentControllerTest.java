package com.cible.backend_cible.controller.task;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.TaskAssignment;
import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.service.task.TaskAssignmentSERVICE;
import com.cible.backend_cible.service.task.TaskSERVICE;
import com.cible.backend_cible.service.task.UserSERVICE;

@ExtendWith(MockitoExtension.class)
public class TaskAssignmentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TaskAssignmentSERVICE taskAssignmentSERVICE;

    @Mock
    private UserSERVICE userSERVICE;

    @Mock
    private TaskSERVICE taskSERVICE;

    @InjectMocks
    private TaskAssignmentController taskAssignmentController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskAssignmentController).build();
    }

    @Test
    void testGetAllTaskAssignments() throws Exception {
        TaskAssignment ta1 = new TaskAssignment();
        ta1.setId(1);
        TaskAssignment ta2 = new TaskAssignment();
        ta2.setId(2);

        when(taskAssignmentSERVICE.getAllTaskAssignments()).thenReturn(List.of(ta1, ta2));

        mockMvc.perform(get("/api/task-assignments/all"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].id").value(1))
               .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    void testGetByUser() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("Alice");

        TaskAssignment ta1 = new TaskAssignment();
        ta1.setId(10);
        TaskAssignment ta2 = new TaskAssignment();
        ta2.setId(20);

        lenient().when(userSERVICE.getUserById(1)).thenReturn(Optional.of(user));

        when(taskAssignmentSERVICE.getByUser(
            argThat(u -> u.getId() != null && u.getId() == 1)
        )).thenReturn(List.of(ta1, ta2));

        mockMvc.perform(get("/api/task-assignments/user/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].id").value(10))
               .andExpect(jsonPath("$[1].id").value(20));
    }

    @Test
    void testGetByTask() throws Exception {
        Task task = new Task();
        task.setId(5);
    
        TaskAssignment ta1 = new TaskAssignment();
        ta1.setId(30);
        TaskAssignment ta2 = new TaskAssignment();
        ta2.setId(40);
    
        when(taskSERVICE.getTaskByIdOptional(5)).thenReturn(Optional.of(task));
    
        when(taskAssignmentSERVICE.getByTask(
            argThat(t -> t.getId() != null && t.getId() == 5)
        )).thenReturn(List.of(ta1, ta2));
    
        mockMvc.perform(get("/api/task-assignments/task/5"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].id").value(30))
               .andExpect(jsonPath("$[1].id").value(40));
    }
    

}
