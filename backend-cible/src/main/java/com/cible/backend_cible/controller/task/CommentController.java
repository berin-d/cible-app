package com.cible.backend_cible.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Iterable<Comment>> getAllComments() {
        Iterable<Comment> comments = commentSERVICE.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        return commentSERVICE.getCommentById(id)
                .map(comment -> ResponseEntity.ok(comment))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment saved = commentSERVICE.createComment(comment);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Iterable<Comment>> getCommentsByUser(@PathVariable Integer userId) {
        Iterable<Comment> comments = commentSERVICE.getCommentsByUserId(userId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<Iterable<Comment>> getCommentsByTask(@PathVariable Integer taskId) {
        Iterable<Comment> comments = commentSERVICE.getCommentsByTaskId(taskId);
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Integer id,
                                                 @RequestBody Comment comment) {
        return commentSERVICE.updateComment(id, comment)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        if (commentSERVICE.deleteComment(id)) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.notFound().build();
    }
}