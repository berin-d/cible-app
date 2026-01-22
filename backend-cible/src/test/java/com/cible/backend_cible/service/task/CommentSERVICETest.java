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

import com.cible.backend_cible.db.task.CommentDB;
import com.cible.backend_cible.model.task.Comment;

@ExtendWith(MockitoExtension.class)
public class CommentSERVICETest {
    
    @Mock
    private CommentDB commentDB;

    @InjectMocks
    private CommentSERVICE commentSERVICE;

    @Test
    void testGetAllActivities() {
        Comment a1 = new Comment();
        Comment a2 = new Comment();

        when(commentDB.findAll()).thenReturn(List.of(a1, a2));

        Iterable<Comment> comments = commentSERVICE.getAllComments();

        assertNotNull(comments);
        verify(commentDB, times(1)).findAll();
    }
}