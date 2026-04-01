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

import com.cible.backend_cible.db.task.ActivityRepository;
import com.cible.backend_cible.model.task.Activity;

@ExtendWith(MockitoExtension.class)
public class ActivitySERVICETest {

    @Mock
    private ActivityRepository activityRepository;

    @InjectMocks
    private ActivitySERVICE activitySERVICE;

    @Test
    void testGetAllActivities() {
        Activity a1 = new Activity();
        Activity a2 = new Activity();

        when(activityRepository.findAll()).thenReturn(List.of(a1, a2));

        Iterable<Activity> activities = activitySERVICE.getAllActivities();

        assertNotNull(activities);
        verify(activityRepository, times(1)).findAll();
    }
}