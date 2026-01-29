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

import com.cible.backend_cible.model.task.Priority;
import com.cible.backend_cible.service.task.PrioritySERVICE;

@RestController
@RequestMapping("/api/priorities")
public class PriorityController {
    
    @Autowired
    private PrioritySERVICE prioritySERVICE;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Priority>> getAllPriorities() {
        return ResponseEntity.ok(prioritySERVICE.getAllPriorities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Priority> getPriorityById(@PathVariable Integer id) {
        return prioritySERVICE.getPriorityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Priority> createPriority(@RequestBody Priority priority) {
        Priority created = prioritySERVICE.createPriority(priority);
        return ResponseEntity.status(201).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriority(@PathVariable Integer id) {
        boolean deleted = prioritySERVICE.deletePriority(id);
    
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}

