package com.cible.backend_cible.controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cible.backend_cible.db.task.TaskRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/years")
public class YearController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Integer> getDistinctYears() {
        return taskRepository.findDistinctYears();
    }
}