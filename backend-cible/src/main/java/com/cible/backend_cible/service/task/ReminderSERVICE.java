package com.cible.backend_cible.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.ReminderDB;
import com.cible.backend_cible.model.task.Reminder;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.User;

@Service
public class ReminderSERVICE {
    

    @Autowired
    private ReminderDB reminderDB;

    public Iterable<Reminder> getAllReminders(){
        return reminderDB.findAll();
    }

    public List<Reminder> getRemindersByUser(User user) {
        return reminderDB.findByUser(user);
    }

    public List<Reminder> getRemindersByTask(Task task) {
        return reminderDB.findByTask(task);
    }

    public Reminder saveReminder(Reminder reminder) {
        return reminderDB.save(reminder);
    }

    public void deleteReminder(Integer id) {
        reminderDB.deleteById(id);
    }
}
