package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.task.TaskRepository;
import com.cible.backend_cible.model.task.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskSERVICETest {

    @Mock
    private TaskRepository taskDB;

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
