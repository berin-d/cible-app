package com.cible.backend_cible.service.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.ReminderRepository;
import com.cible.backend_cible.model.task.Reminder;
import com.cible.backend_cible.model.task.Task;

@Service
public class ReminderSERVICE {
    

    @Autowired
    private ReminderRepository reminderRepository;

    public Iterable<Reminder> getAllReminders(){
        return reminderRepository.findAll();
    }

    public List<Reminder> getRemindersByTask(Task task) {
        return reminderRepository.findByTask(task);
    }

    public Optional<Reminder> getReminderById(Integer id){
        return reminderRepository.findById(id);
    }

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public boolean deleteReminder(Integer id) {
        if (reminderRepository.existsById(id)) {
            reminderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
