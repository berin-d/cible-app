package com.cible.backend_cible.controller.task;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.cible.backend_cible.model.task.Reminder;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.service.task.ReminderSERVICE;

@ExtendWith(MockitoExtension.class)
public class ReminderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReminderSERVICE reminderSERVICE;

    @InjectMocks
    private ReminderController reminderController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(reminderController).build();
    }

    @Test
    void testGetAllReminders() throws Exception {
        Reminder r1 = new Reminder();
        Task task1 = new Task();
        r1.setId(1);
        r1.setTask(task1);


        Task task2 = new Task();
        Reminder r2 = new Reminder();
        r2.setId(2);
        r2.setTask(task2);

        when(reminderSERVICE.getAllReminders()).thenReturn(List.of(r1, r2));

        mockMvc.perform(get("/api/reminders/all")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].task.id").value(task1.getId()))
        .andExpect(jsonPath("$[1].id").value(2))
        .andExpect(jsonPath("$[1].task.id").value(task2.getId()));

    }

    @Test
    void testGetReminderById_Found() throws Exception {
        Reminder r = new Reminder();
        r.setId(1);
        Task task1 = new Task();
        r.setTask(task1);

        when(reminderSERVICE.getReminderById(1)).thenReturn(Optional.of(r));

        mockMvc.perform(get("/api/reminders/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.task.id").value(task1.getId()));

    }

    @Test
    void testGetReminderById_NotFound() throws Exception {
        when(reminderSERVICE.getReminderById(999)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/reminders/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
