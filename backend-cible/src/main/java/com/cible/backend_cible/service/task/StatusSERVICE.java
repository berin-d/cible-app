package com.cible.backend_cible.service.task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.StatusDB;
import com.cible.backend_cible.model.task.Status;

@Service
public class StatusSERVICE {
    
    @Autowired
    private StatusDB statusDB;

    public Iterable<Status> getAllStatus(){
        return statusDB.findAll();
    }

    public Optional<Status> getStatusById(Integer id) {
        return statusDB.findById(id);
    }

    public Optional<Status> getByName(String name) {
        return statusDB.findByName(name);
    }

    public Status createStatus(Status status) {
        return statusDB.save(status);
    }

    public boolean existsByName(String name) {
        return statusDB.existsByName(name);
    }

    public void deleteStatus(Integer id) {
        statusDB.deleteById(id);
    }
    
}
