package com.provenience.project;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Expects JSON
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository projRepo;

    public ProjectController(ProjectRepository projRepo) {
        this.projRepo = projRepo;
    }

    @GetMapping("")
    List<Project> getAllProjects() {
        return projRepo.getAllProjects();
    }

    @GetMapping("/{id}")
    Project getProjectById(@PathVariable Integer id){
        Optional<Project> project = projRepo.getProjectById(id);
        if(project.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        return project.get();
    }

    // post/Create
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // return created status. instead of 200. its 201
    void addProject(@Valid @RequestBody Project project) {
        projRepo.addProject(project);
    }

    // update
    @PutMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateProject(@RequestBody Project project) {
        projRepo.updateProject(project);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteProject(@PathVariable Integer id) {
        projRepo.deleteProject(id);
    }

    //    @GetMapping("/{projectStatus}")
//    List<Project> getProjectByStatus(@PathVariable String projectStatus){
//        List<Project> projectsByStatus = projRepo.getProjectByStatus(projectStatus);
//        if(projectsByStatus.isEmpty()) {
//            throw new ProjectNotFoundException();
//        }
//        return projectsByStatus;
//    }
}
