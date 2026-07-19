package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.goal.GoalRepository;
import com.cible.backend_cible.mapper.task.GoalMapper;
import com.cible.backend_cible.model.dtos.goal.GoalDTO;
import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.service.goal.GoalSERVICE;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GoalSERVICETest {

    @Mock
    private GoalRepository goalRepository;

    @Mock
    private GoalMapper goalMapper;

    @InjectMocks
    private GoalSERVICE goalSERVICE;

    @Test
    void testGetAllGoals() {
        Goal g1 = new Goal();
        Goal g2 = new Goal();

        when(goalRepository.findAll()).thenReturn(List.of(g1, g2));

        List<GoalDTO> groups = goalSERVICE.getAllGoals();

        assertNotNull(groups);
        verify(goalRepository, times(1)).findAll();
    }
}
