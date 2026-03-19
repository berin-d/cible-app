package com.cible.backend_cible.service.task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.StatusRepository;
import com.cible.backend_cible.model.task.Status;

@Service
public class StatusSERVICE {
    
    @Autowired
    private StatusRepository statusRepository;

    public Iterable<Status> getAllStatus(){
        return statusRepository.findAll();
    }

    public Optional<Status> getStatusById(Integer id) {
        return statusRepository.findById(id);
    }

    public Optional<Status> getByName(String name) {
        return statusRepository.findByName(name);
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public boolean existsByName(String name) {
        return statusRepository.existsByName(name);
    }

    public boolean deleteStatus(Integer id) {
        if (!statusRepository.existsById(id)) {
            return false;
        }
        statusRepository.deleteById(id);
        return true;
    }
    
}
