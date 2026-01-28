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
    public ResponseEntity<Iterable<Reminder>> getAllReminders() {
        return ResponseEntity.ok(reminderSERVICE.getAllReminders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Integer id) {
        return reminderSERVICE.getReminderById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }  

    @PostMapping("/")
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        Reminder created = reminderSERVICE.createReminder(reminder);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Integer id) {
        boolean deleted = reminderSERVICE.deleteReminder(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}