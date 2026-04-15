package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.task.StatusRepository;
import com.cible.backend_cible.model.task.Status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StatusSERVICETest {

    @Mock
    private StatusRepository statusDB;

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
