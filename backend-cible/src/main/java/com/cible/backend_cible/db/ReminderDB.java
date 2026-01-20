package com.cible.backend_cible.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.Reminder;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.User;

@Repository
public interface ReminderDB extends CrudRepository<Reminder, Integer> {


        List<Reminder> findByUser(User user);

        List<Reminder> findByTask(Task task);
}
