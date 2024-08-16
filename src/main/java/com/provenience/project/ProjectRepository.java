package com.provenience.project;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository {

    private static final Logger log = LoggerFactory.getLogger(ProjectRepository.class);
    private final JdbcClient jdbcClient;

    public ProjectRepository(JdbcClient jc) {
        this.jdbcClient = jc;
    }

    public List<Project> getAllProjects() {
        return jdbcClient.sql("SELECT * from Project")
                .query(Project.class)
                .list();
    }
    public Optional<Project> getProjectById(Integer id) {
        return jdbcClient.sql("SELECT id, name, startedOn, endedOn, projectStatus FROM Project WHERE id = :id")
                .param("id", id)
                .query(Project.class).optional();
    }

    public List<Project> getProjectByStatus(String projectStatus) {
        return jdbcClient.sql("SELECT * from Project where projectStatus = :projectStatus")
                .param("projectStatus", projectStatus)
                .query(Project.class).list();
    }

    public void addProject(Project newProject) {
        var updated = jdbcClient.sql("INSERT INTO Project( id, name, startedOn, endedOn, projectStatus) VALUES (?,?,?,?,?)")
                .params(List.of(newProject.id(), newProject.name(), newProject.startedOn(), newProject.endedOn(), newProject.projectStatus().toString()))
                .update();
        Assert.state(updated == 1, "Failed to create Project " + newProject.name());
    }

    public void updateProject(Project newProject) {
        var updatedRows = jdbcClient.sql("UPDATE Project set name = ?, startedOn = ?, endedOn = ?, projectStatus = ? where id = ? ")
                .params(List.of(newProject.name(), newProject.startedOn(), newProject.endedOn(), newProject.projectStatus().toString(), newProject.id()))
                .update();
        Assert.state(updatedRows == 1, "FAiled to update the project " + newProject.name());
    }

    public void deleteProject(Integer id) {
        var updatedRows = jdbcClient.sql("DELETE from Project where id = :id").param("id", id).update();
        Assert.state(updatedRows == 1, "Failed to delete the project with id " + id);
    }

    public int count() {
        return jdbcClient.sql("SELECT * from Project").query().listOfRows().size();
    }

    public void saveAllProjects(List<Project> projects ) {
        projects.stream().forEach(this:: addProject);
    }
}
