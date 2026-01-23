package com.cible.backend_cible.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cible.backend_cible.model.task.Comment;
import com.cible.backend_cible.service.task.CommentSERVICE;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    
    @Autowired
    private CommentSERVICE commentSERVICE;

    @GetMapping("/all")
    public Iterable<Comment> getAllComments() {
        return commentSERVICE.getAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        return commentSERVICE.getCommentById(id)
                .map(comment -> ResponseEntity.ok(comment))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Comment createComment(@RequestBody Comment comment) {
        return commentSERVICE.createComment(comment);
    }

    @GetMapping("/user/{userId}")
    public Iterable<Comment> getCommentsByUser(@PathVariable Integer userId) {
        return commentSERVICE.getCommentsByUserId(userId);
    }

    @GetMapping("/task/{taskId}")
    public Iterable<Comment> getCommentsByTask(@PathVariable Integer taskId) {
        return commentSERVICE.getCommentsByTaskId(taskId);
    }
}