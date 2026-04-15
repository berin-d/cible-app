package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.task.TaskAssignmentRepository;
import com.cible.backend_cible.model.task.TaskAssignment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskAssignmentSERVICETest {

    @Mock
    private TaskAssignmentRepository taskAssignmentDB;

    @InjectMocks
    private TaskAssignmentSERVICE taskAssignmentSERVICE;

    @Test
    void testGetAllTaskAssignments() {
        TaskAssignment a1 = new TaskAssignment();
        TaskAssignment a2 = new TaskAssignment();

        when(taskAssignmentDB.findAll()).thenReturn(List.of(a1, a2));

        Iterable<TaskAssignment> assignments = taskAssignmentSERVICE.getAllTaskAssignments();

        assertNotNull(assignments);
        verify(taskAssignmentDB, times(1)).findAll();
    }
}