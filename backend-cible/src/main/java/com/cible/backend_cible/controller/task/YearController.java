package com.cible.backend_cible.controller.task;

import com.cible.backend_cible.db.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/years")
public class YearController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Integer> getDistinctYears() {
        return taskRepository.findDistinctYears();
    }
}