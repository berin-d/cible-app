package com.cible.backend_cible.mapper.task;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.cible.backend_cible.model.dtos.task.CommentDTO;
import com.cible.backend_cible.model.task.Comment;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.User;
import static org.assertj.core.api.Assertions.assertThat;

public class CommentMapperTest {

    private final CommentMapper mapper = CommentMapper.INSTANCE;

    @Test
    void shouldMapEntityToDto() {
        User user = new User();
        user.setId(10);

        Task task = new Task();
        task.setId(20);

        Comment comment = new Comment();
        comment.setId(1);
        comment.setContent("Hello world");
        comment.setUser(user);
        comment.setTask(task);
        comment.setCreatedAt(LocalDateTime.now());

        CommentDTO dto = mapper.toDto(comment);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1);
        assertThat(dto.getContent()).isEqualTo("Hello world");
        assertThat(dto.getUserId()).isEqualTo(10);
        assertThat(dto.getTaskId()).isEqualTo(20);
    }

    @Test
    void shouldMapDtoToEntity() {
        CommentDTO dto = new CommentDTO();
        dto.setId(5);
        dto.setContent("Test comment");
        dto.setUserId(30);
        dto.setTaskId(40);

        Comment comment = mapper.toEntity(dto);

        assertThat(comment).isNotNull();
        assertThat(comment.getId()).isEqualTo(5);
        assertThat(comment.getContent()).isEqualTo("Test comment");

        assertThat(comment.getUser()).isNull();
        assertThat(comment.getTask()).isNull();
        assertThat(comment.getCreatedAt()).isNull();
    }
}
