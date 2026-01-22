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

import com.cible.backend_cible.db.task.TaskDB;
import com.cible.backend_cible.model.task.Task;

@ExtendWith(MockitoExtension.class)
public class TaskSERVICETest {

    @Mock
    private TaskDB taskDB;

    @InjectMocks
    private TaskSERVICE taskSERVICE;

    @Test
    void testGetAllTasks() {
        Task t1 = new Task();
        Task t2 = new Task();

        when(taskDB.findAll()).thenReturn(List.of(t1, t2));

        Iterable<Task> tasks = taskSERVICE.getAllTasks();

        assertNotNull(tasks);
        verify(taskDB, times(1)).findAll();
    }
}
