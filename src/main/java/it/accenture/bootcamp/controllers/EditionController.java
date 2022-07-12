package it.accenture.bootcamp.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.accenture.bootcamp.dtos.EditionDTO;
import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.models.Edition;

@RestController
@RequestMapping("edition")
public class EditionController {

    @GetMapping
    public Iterable<EditionDTO> getAll() {
        // simulation of getting the edition from a database
        // List<Edition> editions = new ArrayList<>();
        // Course course = new Course(1, "Java", 100);
        // Classroom classroom = new Classroom(1, "Aula magna");
        // Edition edition1 = new Edition(1, LocalDate.now(), LocalDate.now(), course,
        // classroom);
        // Edition edition2 = new Edition(2, LocalDate.now(), LocalDate.now(), course,
        // classroom);
        // editions.add(edition1);
        // editions.add(edition2);
        // return the DTO
        // return editions.stream().map(EditionDTO::fromEdition).toList();
        return null;
    }
}
