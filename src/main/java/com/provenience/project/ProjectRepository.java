package com.provenience.project;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepository {
    private List<Project> projects = new ArrayList<>();

    List<Project> getAllProjects() {
        return projects;
    }
    @PostConstruct
    private void init() {
        projects.add(new Project(1, "project1", LocalDate.now(), LocalDate.now(), ProjectStatus.COMPLETED ));
        projects.add(new Project(2, "project2", LocalDate.now(), LocalDate.now(), ProjectStatus.PROGRESS ));
    }
}
