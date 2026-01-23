package com.cible.backend_cible.controller.system;

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

import com.cible.backend_cible.model.system.Notification;
import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.service.system.NotificationSERVICE;
import com.cible.backend_cible.service.task.UserSERVICE;

@ExtendWith(MockitoExtension.class)
public class NotificationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private NotificationSERVICE notificationSERVICE;

    @Mock
    private UserSERVICE userSERVICE;

    @InjectMocks
    private NotificationController notificationController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(notificationController).build();
    }

    @Test
    void testGetAllNotifications() throws Exception {
        Notification n1 = new Notification();
        n1.setId(1);

        Notification n2 = new Notification();
        n2.setId(2);

        when(notificationSERVICE.getAllNotifications()).thenReturn(List.of(n1, n2));

        mockMvc.perform(get("/api/notifications/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    void testGetNotificationsByUser_Found() throws Exception {
        User user = new User();
        user.setId(1);

        Notification n1 = new Notification();
        n1.setId(101);

        Notification n2 = new Notification();
        n2.setId(102);

        when(userSERVICE.getUserById(1)).thenReturn(Optional.of(user));
        when(notificationSERVICE.getNotificationsByUser(user)).thenReturn(List.of(n1, n2));

        mockMvc.perform(get("/api/notifications/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(101))
                .andExpect(jsonPath("$[1].id").value(102));
    }

    @Test
    void testGetNotificationsByUser_NotFound() throws Exception {
        when(userSERVICE.getUserById(999)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/notifications/user/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
