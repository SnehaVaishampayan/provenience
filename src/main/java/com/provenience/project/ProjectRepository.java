package com.provenience.project;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository {
    private List<Project> projects = new ArrayList<>();

    List<Project> getAllProjects() {
        return projects;
    }
    Optional<Project> getProjectById(Integer id) {
        return projects.stream().filter(project -> project.id() == id).findFirst();
    }

    @PostConstruct
    private void init() {
        projects.add(new Project(1, "project1", LocalDate.now(), LocalDate.now(), ProjectStatus.COMPLETED ));
        projects.add(new Project(2, "project2", LocalDate.now(), LocalDate.now(), ProjectStatus.PROGRESS ));
    }

    void addProject(Project project) {
        projects.add(project);
    }
    void updateProject(Project project) {
        Optional<Project> oldProject = getProjectById(project.id());
        if(oldProject.isPresent()) {
            projects.set(projects.indexOf(oldProject.get()), project);
        }
    }

    void delete(Integer id) {
        projects.removeIf(project -> project.id().equals(id));
    }
}
