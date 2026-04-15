package com.cible.backend_cible.service.system;

import com.cible.backend_cible.db.system.NotificationRepository;
import com.cible.backend_cible.model.system.Notification;
import com.cible.backend_cible.model.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationSERVICETest {

    @Mock
    private NotificationRepository notificationDB;

    @InjectMocks
    private NotificationSERVICE notificationSERVICE;

    @Test
    void testFindByUser() {
        User user = new User();
        Notification n1 = new Notification();
        Notification n2 = new Notification();

        when(notificationDB.findByUser(user)).thenReturn(List.of(n1, n2));

        List<Notification> notifications = notificationSERVICE.getNotificationsByUser(user);

        assertNotNull(notifications);
        verify(notificationDB, times(1)).findByUser(user);
    }
}