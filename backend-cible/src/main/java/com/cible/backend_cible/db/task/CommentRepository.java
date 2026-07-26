package com.cible.backend_cible.db.task;

import com.cible.backend_cible.model.task.Comment;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    
    List<Comment> findByUser(User user);

    List<Comment> findByUser_Id(Integer userId);

    List<Comment> findByTask(Task task);

    List<Comment> findByTask_Id(Integer taskId);
}
