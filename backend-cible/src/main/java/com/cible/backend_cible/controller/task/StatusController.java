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
    public ResponseEntity<Iterable<Status>> getAllStatuses() {
        return ResponseEntity.ok(statusSERVICE.getAllStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Integer id) {
        return statusSERVICE.getStatusById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/")
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        Status created = statusSERVICE.createStatus(status);
        return ResponseEntity.ok(created);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Integer id) {
        boolean deleted = statusSERVICE.deleteStatus(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
