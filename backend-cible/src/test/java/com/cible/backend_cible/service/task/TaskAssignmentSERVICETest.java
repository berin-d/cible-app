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

import com.cible.backend_cible.db.task.TaskAssignmentRepository;
import com.cible.backend_cible.model.task.TaskAssignment;

@ExtendWith(MockitoExtension.class)
public class TaskAssignmentSERVICETest {

    @Mock
    private TaskAssignmentRepository taskAssignmentRepository;

    @InjectMocks
    private TaskAssignmentSERVICE taskAssignmentSERVICE;

    @Test
    void testGetAllTaskAssignments() {
        TaskAssignment a1 = new TaskAssignment();
        TaskAssignment a2 = new TaskAssignment();

        when(taskAssignmentRepository.findAll()).thenReturn(List.of(a1, a2));

        Iterable<TaskAssignment> assignments = taskAssignmentSERVICE.getAllTaskAssignments();

        assertNotNull(assignments);
        verify(taskAssignmentRepository, times(1)).findAll();
    }
}