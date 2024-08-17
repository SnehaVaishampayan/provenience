package com.provenience.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ProjectJSONLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(ProjectJSONLoader.class);
    private final ProjectRepository projectRepository;
    private final ObjectMapper objectMapper;
    public ProjectJSONLoader(ProjectRepository projRepo, ObjectMapper objectMapper) {
        this.projectRepository = projRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(projectRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/projects.json")) {
                ProjectsList projectsList = objectMapper.readValue(inputStream, ProjectsList.class);
                log.info("projectsList " + projectsList.toString());
                projectRepository.saveAllProjects(projectsList.projects());
            }
            catch (IOException ioe) {
                throw new RuntimeException("Failed to read JSON " + ioe);
            }
        }
        else {
            log.info("JSON data not loaded. The collection contains data. ");
        }
    }
}
