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

import com.cible.backend_cible.db.task.PriorityDB;
import com.cible.backend_cible.model.task.Priority;

@ExtendWith(MockitoExtension.class)
public class PrioritySERVICETest {

    @Mock
    private PriorityDB priorityDB;

    @InjectMocks
    private PrioritySERVICE prioritySERVICE;

    @Test
    void testGetAllPriorities() {
        Priority p1 = new Priority();
        Priority p2 = new Priority();

        when(priorityDB.findAll()).thenReturn(List.of(p1, p2));

        Iterable<Priority> priorities = prioritySERVICE.getAllPriorities();

        assertNotNull(priorities);
        verify(priorityDB, times(1)).findAll();
    }
}