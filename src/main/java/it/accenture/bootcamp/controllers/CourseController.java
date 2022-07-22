package it.accenture.bootcamp.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import it.accenture.bootcamp.dtos.EditionDTO;
import it.accenture.bootcamp.mapstruct.CourseMapper;
import it.accenture.bootcamp.mapstruct.EditionMapper;
import it.accenture.bootcamp.models.Edition;
import it.accenture.bootcamp.services.implementations.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.accenture.bootcamp.dtos.CourseDTO;
import it.accenture.bootcamp.exceptions.EntityNotFoundException;
import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.services.abstractions.EducationService;

@RestController
@CrossOrigin
@RequestMapping("course")
public class CourseController {
    private EducationService eduService;
    private CourseService crudService;

    @Autowired
    public CourseController(EducationService eduService, CourseService crudService) {
        this.eduService = eduService;
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<CourseDTO>> getCourses(@RequestParam(required = false) String sectorName,
                                                          @RequestParam(required = false) String like,
                                                          @RequestParam(required = false) Integer duration,
                                                          @RequestParam(required = false) Integer cost,
                                                          @RequestParam(required = false) Boolean noEdition) {
        Iterable<Course> cls = null;
        if(like != null) {
            cls = crudService.findByTitleContaining(like);
        } else if(sectorName != null) {
            cls = crudService.findBySectorName(sectorName);
        } else if(duration != null && cost != null) {
            cls = crudService.findByDurationGreaterThanAndCostLessThan(duration, cost);
        } else if(noEdition != null && noEdition) {
            cls = crudService.findByNoEdition();
        } else {
            cls = crudService.getAll();
            //System.out.println("getAll");
        }
        var dtos = StreamSupport.stream(cls.spliterator(), false).map(CourseMapper.INSTANCE::fromCourse).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}/editions")
    public ResponseEntity<Iterable<EditionDTO>> findEditionsByCourse(@PathVariable long id) {
        List<Edition> editions = crudService.findEditionsByCourse(id);
        var dtos = editions.stream().map(EditionMapper.INSTANCE::fromEdition).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable long id) {
        Optional<Course> optClass = crudService.findById(id);
        if (optClass.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optClass.map(CourseMapper.INSTANCE::fromCourse).get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            crudService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CourseDTO cdto) {
        Course c = CourseMapper.INSTANCE.toCourse(cdto);
        try {
            Course cSaved = crudService.saveOrUpdate(c);
            var dto = CourseMapper.INSTANCE.fromCourse(cSaved);
            URI uri = new URI("localhost:8080/course/" + cdto.getId());
            return ResponseEntity.created(uri).body(dto);
        } catch (URISyntaxException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody CourseDTO cdto, @PathVariable long id) {
        Course c = CourseMapper.INSTANCE.toCourse(cdto);
        try {
            Course cSaved = crudService.saveOrUpdate(c);
            CourseDTO dto = CourseMapper.INSTANCE.fromCourse(cSaved);
            return ResponseEntity.ok(dto);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}