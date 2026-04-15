package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.task.ActivityRepository;
import com.cible.backend_cible.model.task.Activity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ActivitySERVICETest {

    @Mock
    private ActivityRepository activityDB;

    @InjectMocks
    private ActivitySERVICE activitySERVICE;

    @Test
    void testGetAllActivities() {
        Activity a1 = new Activity();
        Activity a2 = new Activity();

        when(activityDB.findAll()).thenReturn(List.of(a1, a2));

        Iterable<Activity> activities = activitySERVICE.getAllActivities();

        assertNotNull(activities);
        verify(activityDB, times(1)).findAll();
    }
}