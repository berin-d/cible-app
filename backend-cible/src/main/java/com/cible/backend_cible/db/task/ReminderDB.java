package com.cible.backend_cible.db.task;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.Reminder;
import com.cible.backend_cible.model.task.Task;

@Repository
public interface ReminderDB extends CrudRepository<Reminder, Integer> {


        List<Reminder> findByTask(Task task);
}
