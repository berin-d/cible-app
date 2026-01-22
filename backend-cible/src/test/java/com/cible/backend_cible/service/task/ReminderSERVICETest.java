package com.cible.backend_cible.service.task;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cible.backend_cible.db.task.ReminderDB;
import com.cible.backend_cible.model.task.Reminder;

@ExtendWith(MockitoExtension.class)
public class ReminderSERVICETest {

    @Mock
    private ReminderDB reminderDB;

    @InjectMocks
    private ReminderSERVICE reminderSERVICE;

    @Test
    void testGetAllReminders() {
        Reminder r1 = new Reminder();
        Reminder r2 = new Reminder();

        when(reminderDB.findAll()).thenReturn(List.of(r1, r2));

        Iterable<Reminder> reminders = reminderSERVICE.getAllReminders();

        assertNotNull(reminders);
        verify(reminderDB, times(1)).findAll();
    }
}
