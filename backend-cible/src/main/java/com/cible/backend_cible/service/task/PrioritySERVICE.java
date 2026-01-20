package com.cible.backend_cible.service.task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.PriorityDB;
import com.cible.backend_cible.model.task.Priority;

@Service
public class PrioritySERVICE {
    
    @Autowired
    private PriorityDB priorityDB;

    public Iterable<Priority> getAllPriorities(){
        return priorityDB.findAll();
    }

     public Optional<Priority> getPriorityById(Integer id) {
        return priorityDB.findById(id);
    }

    public Optional<Priority> getPriorityByName(String name) {
        return priorityDB.findByName(name);
    }

    public Priority savePriority(Priority priority) {
        return priorityDB.save(priority);
    }

    public void deletePriority(Integer id) {
        priorityDB.deleteById(id);
    }
}
