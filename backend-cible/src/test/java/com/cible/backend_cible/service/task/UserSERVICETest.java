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

import com.cible.backend_cible.db.task.UserDB;
import com.cible.backend_cible.model.task.User;

@ExtendWith(MockitoExtension.class)
public class UserSERVICETest {

    @Mock
    private UserDB userDB;

    @InjectMocks
    private UserSERVICE userSERVICE;

    @Test
    void testGetAllUsers() {
        User u1 = new User();
        User u2 = new User();

        when(userDB.findAll()).thenReturn(List.of(u1, u2));

        Iterable<User> users = userSERVICE.getAllUsers();

        assertNotNull(users);
        verify(userDB, times(1)).findAll();
    }
}
