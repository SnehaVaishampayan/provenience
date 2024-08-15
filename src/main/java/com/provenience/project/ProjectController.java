package com.provenience.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Expects JSON
@RestController
public class ProjectController {

//    @GetMapping("/home")
//    String home() {
//        return "Home page";
//    }

    private final ProjectRepository projRepo;

    public ProjectController(ProjectRepository projRepo) {
        this.projRepo = projRepo;
    }
    @GetMapping("/api/getAllProjects")
    List<Project> getAllProjects() {
        return projRepo.getAllProjects();
    }
}
