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
    public Iterable<Priority> getAllPriorities() {
        return prioritySERVICE.getAllPriorities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Priority> getPriorityById(@PathVariable Integer id) {
        return prioritySERVICE.getPriorityById(id)
                .map(priority -> ResponseEntity.ok(priority))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/")
    public Priority createPriority(@RequestBody Priority priority) {
        return prioritySERVICE.createPriority(priority);
    }

    @DeleteMapping("/{id}")
    public void deletePriority(@PathVariable Integer id) {
        prioritySERVICE.deletePriority(id);
    }
}

