package com.cible.backend_cible.controller.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cible.backend_cible.model.task.Reminder;
import com.cible.backend_cible.service.task.ReminderSERVICE;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
    
    @Autowired
    private ReminderSERVICE reminderSERVICE;

    @GetMapping("/all")
    public Iterable<Reminder> getAllReminders() {
        return reminderSERVICE.getAllReminders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Integer id) {
        return reminderSERVICE.getReminderById(id)
                .map(reminder -> ResponseEntity.ok(reminder))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }    

    @PostMapping("/")
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return reminderSERVICE.createReminder(reminder);
    }

    @DeleteMapping("/{id}")
    public void deleteReminder(@PathVariable Integer id) {
        reminderSERVICE.deleteReminder(id);
    }
}