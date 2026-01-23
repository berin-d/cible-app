package com.cible.backend_cible.controller.task;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cible.backend_cible.model.task.Comment;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.service.task.CommentSERVICE;

@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CommentSERVICE commentSERVICE;

    @InjectMocks
    private CommentController commentController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
    }

    @Test
    void testGetAllComments() throws Exception {
        Comment c1 = new Comment();
        c1.setId(1);
        Comment c2 = new Comment();
        c2.setId(2);

        when(commentSERVICE.getAllComments()).thenReturn(List.of(c1, c2));

        mockMvc.perform(get("/api/comments/all")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    void testGetCommentById_Found() throws Exception {
        Comment c = new Comment();
        c.setId(1);

        when(commentSERVICE.getCommentById(1)).thenReturn(Optional.of(c));

        mockMvc.perform(get("/api/comments/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testGetCommentById_NotFound() throws Exception {
        when(commentSERVICE.getCommentById(999)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/comments/999")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }

    @Test
    void testGetCommentsByUser() throws Exception {
        User user = new User();
        user.setId(1);

        Comment c1 = new Comment();
        c1.setId(10);
        Comment c2 = new Comment();
        c2.setId(20);

        when(commentSERVICE.getCommentsByUserId(1)).thenReturn(List.of(c1, c2));

        mockMvc.perform(get("/api/comments/user/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(10))
            .andExpect(jsonPath("$[1].id").value(20));
    }

    @Test
    void testGetCommentsByTask() throws Exception {
        Task task = new Task();
        task.setId(1);

        Comment c1 = new Comment();
        c1.setId(100);
        Comment c2 = new Comment();
        c2.setId(200);

        when(commentSERVICE.getCommentsByTaskId(1)).thenReturn(List.of(c1, c2));

        mockMvc.perform(get("/api/comments/task/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(100))
            .andExpect(jsonPath("$[1].id").value(200));
    }
}
