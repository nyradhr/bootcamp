package it.accenture.bootcamp.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.stream.StreamSupport;

import it.accenture.bootcamp.mapstruct.ClassroomMapper;
import it.accenture.bootcamp.services.implementations.ClassroomCrudService;
import it.accenture.bootcamp.services.abstractions.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.accenture.bootcamp.dtos.ClassroomDTO;
import it.accenture.bootcamp.exceptions.EntityNotFoundException;
import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.services.abstractions.EducationService;

@RestController
@RequestMapping("classroom")
public class ClassroomController {

    private EducationService eduService;
    private ClassroomCrudService crudService;
    //private AbstractCrudService<Classroom, Long> crudService;

    @Autowired
    public ClassroomController(EducationService eduService, ClassroomCrudService crudService) {
        this.eduService = eduService;
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ClassroomDTO>> getAll() {
        var cls = crudService.getAll();
        var dtos = StreamSupport.stream(cls.spliterator(), false).map(ClassroomMapper.INSTANCE::fromClassroom).toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClassroomDTO> findById(@PathVariable long id) {
        Optional<Classroom> optClass = crudService.findById(id);
        if (optClass.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optClass.map(ClassroomMapper.INSTANCE::fromClassroom).get());
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
    public ResponseEntity<?> create(@RequestBody ClassroomDTO cdto) {
        Classroom c = ClassroomMapper.INSTANCE.toClassroom(cdto);
        try {
            Classroom cSaved = crudService.saveOrUpdate(c);
            ClassroomDTO dto = ClassroomMapper.INSTANCE.fromClassroom(c);
            URI uri = new URI("localhost:8080/classroom/" + dto.getId());
            return ResponseEntity.created(uri).body(dto);
        } catch (URISyntaxException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody ClassroomDTO cdto, @PathVariable long id) {
        Classroom c = ClassroomMapper.INSTANCE.toClassroom(cdto);
        try {
            Classroom cSaved = crudService.saveOrUpdate(c);
            ClassroomDTO dto = ClassroomMapper.INSTANCE.fromClassroom(c);
            return ResponseEntity.ok(dto);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}