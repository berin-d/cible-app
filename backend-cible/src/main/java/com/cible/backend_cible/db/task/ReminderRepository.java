package com.cible.backend_cible.db.task;

import com.cible.backend_cible.model.task.Reminder;
import com.cible.backend_cible.model.task.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepository extends CrudRepository<Reminder, Integer> {


        List<Reminder> findByTask(Task task);
}
