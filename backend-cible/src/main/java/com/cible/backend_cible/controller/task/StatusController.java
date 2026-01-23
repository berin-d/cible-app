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
import com.cible.backend_cible.model.task.Status;
import com.cible.backend_cible.service.task.StatusSERVICE;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {
    
  @Autowired
    private StatusSERVICE statusSERVICE;

    @GetMapping("/all")
    public Iterable<Status> getAllStatuses() {
        return statusSERVICE.getAllStatus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Integer id) {
        return statusSERVICE.getStatusById(id)
                .map(status -> ResponseEntity.ok(status))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/")
    public Status createStatus(@RequestBody Status status) {
        return statusSERVICE.createStatus(status);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Integer id) {
        statusSERVICE.deleteStatus(id);
    }
}
