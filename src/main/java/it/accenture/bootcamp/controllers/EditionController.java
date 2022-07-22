package it.accenture.bootcamp.controllers;

import it.accenture.bootcamp.mapstruct.EditionMapper;
import it.accenture.bootcamp.services.abstractions.EducationService;
import it.accenture.bootcamp.services.implementations.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.accenture.bootcamp.dtos.EditionDTO;
import it.accenture.bootcamp.models.Edition;

import java.util.stream.StreamSupport;

@RestController
@CrossOrigin
@RequestMapping("edition")
public class EditionController {

    private EducationService eduService;
    private EditionService crudService;

    @Autowired
    public EditionController(EducationService eduService, EditionService crudService) {
        this.eduService = eduService;
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<EditionDTO>> getEditions(@RequestParam(required = false) Boolean latestEditions) {
        Iterable<Edition> els = null;
        if(latestEditions != null) {
            els = crudService.findTop4ByOrderByStartDateDesc();
        } else {
            els = crudService.getAll();
        }
        var dtos = StreamSupport.stream(els.spliterator(), false).map(EditionMapper.INSTANCE::fromEdition).toList();
        return ResponseEntity.ok(dtos);
    }



}
