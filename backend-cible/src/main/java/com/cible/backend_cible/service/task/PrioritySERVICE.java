package com.cible.backend_cible.service.task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.PriorityRepository;
import com.cible.backend_cible.model.task.Priority;

@Service
public class PrioritySERVICE {
    
    @Autowired
    private PriorityRepository priorityRepository;

    public Iterable<Priority> getAllPriorities(){
        return priorityRepository.findAll();
    }

     public Optional<Priority> getPriorityById(Integer id) {
        return priorityRepository.findById(id);
    }

    public Optional<Priority> getPriorityByName(String name) {
        return priorityRepository.findByName(name);
    }

    public Priority createPriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    public boolean deletePriority(Integer id) {
        if (!priorityRepository.existsById(id)) {
            return false;
        }
        priorityRepository.deleteById(id);
        return true;
    }
    
}
