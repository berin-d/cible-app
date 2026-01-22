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

import com.cible.backend_cible.db.task.StatusDB;
import com.cible.backend_cible.model.task.Status;

@ExtendWith(MockitoExtension.class)
public class StatusSERVICETest {

    @Mock
    private StatusDB statusDB;

    @InjectMocks
    private StatusSERVICE statusSERVICE;

    @Test
    void testGetAllStatus() {
        Status s1 = new Status();
        Status s2 = new Status();

        when(statusDB.findAll()).thenReturn(List.of(s1, s2));

        Iterable<Status> status = statusSERVICE.getAllStatus();

        assertNotNull(status);
        verify(statusDB, times(1)).findAll();
    }
}
