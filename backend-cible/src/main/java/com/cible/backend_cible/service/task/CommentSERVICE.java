package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.task.CommentRepository;
import com.cible.backend_cible.model.task.Comment;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentSERVICE {
    
    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Integer id){
        return commentRepository.findById(id);
    }

      public List<Comment> getCommentsByUser(User user) {
        return commentRepository.findByUser(user);
    }

    public List<Comment> getCommentsByUserId(Integer userId) {
        return commentRepository.findByUser_Id(userId);
    }

    public List<Comment> getCommentsByTask(Task task) {
        return commentRepository.findByTask(task);
    }

    public List<Comment> getCommentsByTaskId(Integer taskId) {
        return commentRepository.findByTask_Id(taskId);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> updateComment(Integer id, Comment newData) {
        return commentRepository.findById(id).map(existing -> {
            existing.setContent(newData.getContent());    
            return commentRepository.save(existing);
        });
    }
    
    public boolean deleteComment(Integer id) {
        if (!commentRepository.existsById(id)) {
            return false;
        }
        commentRepository.deleteById(id);
        return false;
    }
    

}
