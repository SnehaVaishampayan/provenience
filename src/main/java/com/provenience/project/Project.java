package com.provenience.project;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record Project(
        @NotNull
        Integer id,
        @NotEmpty
        String name,
        LocalDate startedOn,
        LocalDate endedOn,
        ProjectStatus projectStatus
) {
    // Validation of data
    public Project {
//        if(!endedOn().isAfter(startedOn())) {
//            throw new IllegalArgumentException(" Project End date is before Start date. ");
//        }
    }
}
