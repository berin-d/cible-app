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

import com.cible.backend_cible.db.task.TaskGroupDB;
import com.cible.backend_cible.mapper.task.TaskGroupMapper;
import com.cible.backend_cible.model.dtos.task.TaskGroupDTO;
import com.cible.backend_cible.model.task.TaskGroup;

@ExtendWith(MockitoExtension.class)
public class TaskGroupSERVICETest {

    @Mock
    private TaskGroupDB taskGroupDB;

    @Mock
    private TaskGroupMapper taskGroupMapper;

    @InjectMocks
    private TaskGroupSERVICE taskGroupSERVICE;

    @Test
    void testGetAllTaskGroups() {
        TaskGroup g1 = new TaskGroup();
        TaskGroup g2 = new TaskGroup();

        when(taskGroupDB.findAll()).thenReturn(List.of(g1, g2));

        List<TaskGroupDTO> groups = taskGroupSERVICE.getAllTaskGroups();

        assertNotNull(groups);
        verify(taskGroupDB, times(1)).findAll();
    }
}
