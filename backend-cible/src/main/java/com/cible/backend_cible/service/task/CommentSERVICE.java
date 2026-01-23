package com.cible.backend_cible.service.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.CommentDB;
import com.cible.backend_cible.model.task.Comment;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.User;

@Service
public class CommentSERVICE {
    
    @Autowired
    private CommentDB commentDB;

    public Iterable<Comment> getAllComments(){
        return commentDB.findAll();
    }

    public Optional<Comment> getCommentById(Integer id){
        return commentDB.findById(id);
    }

      public List<Comment> getCommentsByUser(User user) {
        return commentDB.findByUser(user);
    }

    public List<Comment> getCommentsByUserId(Integer userId) {
        return commentDB.findByUser_Id(userId);
    }

    public List<Comment> getCommentsByTask(Task task) {
        return commentDB.findByTask(task);
    }

    public List<Comment> getCommentsByTaskId(Integer taskId) {
        return commentDB.findByTask_Id(taskId);
    }

    public Comment createComment(Comment comment) {
        return commentDB.save(comment);
    }

}
