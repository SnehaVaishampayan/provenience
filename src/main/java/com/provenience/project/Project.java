package com.provenience.project;

import java.time.LocalDate;

public record Project(
        Integer id,
    String name,
    LocalDate startedOn,
    LocalDate endedOn,
    ProjectStatus projectStatus
) {}
