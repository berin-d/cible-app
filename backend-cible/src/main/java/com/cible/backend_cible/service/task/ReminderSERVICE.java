package com.cible.backend_cible.service.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.ReminderDB;
import com.cible.backend_cible.model.task.Reminder;
import com.cible.backend_cible.model.task.Task;

@Service
public class ReminderSERVICE {
    

    @Autowired
    private ReminderDB reminderDB;

    public Iterable<Reminder> getAllReminders(){
        return reminderDB.findAll();
    }

    public List<Reminder> getRemindersByTask(Task task) {
        return reminderDB.findByTask(task);
    }

    public Optional<Reminder> getReminderById(Integer id){
        return reminderDB.findById(id);
    }

    public Reminder createReminder(Reminder reminder) {
        return reminderDB.save(reminder);
    }

    public void deleteReminder(Integer id) {
        reminderDB.deleteById(id);
    }
}
