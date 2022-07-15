package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.repositories.abstractions.CourseRepository;
import it.accenture.bootcamp.repositories.abstractions.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.accenture.bootcamp.repositories.abstractions.ClassroomRepository;
import it.accenture.bootcamp.services.abstractions.EducationService;

@Service
//@AllArgsConstructor
public class EducationServiceImpl implements EducationService {
    //    private CrudService<Classroom, Long, ClassroomRepository> crudClassroom;
//    private CrudService<Course, Long, CourseRepository> crudCourse;
//    private CrudService<Sector, Long, SectorRepository> crudSector;
    private ClassroomRepository classroomRepo;
    private SectorRepository sectorRepo;
    private CourseRepository courseRepo;
    public static final String ERROR_NOT_FOUND = "L'entità %s con id %d non esiste";

    @Autowired
    public EducationServiceImpl(
//                                CrudService<Classroom, Long, ClassroomRepository> crudClassroom,
//                                CrudService<Course, Long, CourseRepository> crudCourse,
//                                CrudService<Sector, Long, SectorRepository> crudSector,
            ClassroomRepository classroomRepo, CourseRepository courseRepo,
            SectorRepository sectorRepo
    ) {
//        this.crudClassroom = crudClassroom;
//        this.crudCourse = crudCourse;
//        this.crudSector = crudSector;
        this.classroomRepo = classroomRepo;
        this.courseRepo = courseRepo;
        this.sectorRepo = sectorRepo;
    }

//    @Override
//    public Iterable<Classroom> getAllClassrooms() {
//        return null;
//    }
//
//    @Override
//    public void deleteClassroom(Classroom c) throws EntityNotFoundException {
//
//    }
//
//    @Override
//    public void deleteClassroomById(long id) throws EntityNotFoundException {
//
//    }
//
//    @Override
//    public Optional<Classroom> findClassroomById(long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Classroom saveOrUpdateClassroom(Classroom c) throws EntityNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean classroomExists(long id) {
//        return false;
//    }
//
//    @Override
//    public Iterable<Course> getAllCourses() {
//        return null;
//    }
//
//    @Override
//    public void deleteCourse(Course c) throws EntityNotFoundException {
//
//    }
//
//    @Override
//    public void deleteCourseById(long id) throws EntityNotFoundException {
//
//    }
//
//    @Override
//    public Optional<Course> findCourseById(long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Course saveOrUpdateCourse(Course c) throws EntityNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean courseExists(long id) {
//        return false;
//    }
//
//    @Override
//    public Iterable<Classroom> getAllClassrooms() {
//        return classroomRepo.findAll();
//    }
//
//    @Transactional
//    @Override
//    public void deleteClassroom(Classroom c) throws EntityNotFoundException {
//        if (classroomExists(c.getId())) {
//            classroomRepo.delete(c);
//        } else {
//            throw new EntityNotFoundException(ERROR_NOT_FOUND, Classroom.class, c.getId());
//        }
//
//    }
//
//    @Transactional
//    @Override
//    public void deleteClassroomById(long id) throws EntityNotFoundException {
//        if (classroomExists(id)) {
//            classroomRepo.deleteById(id);
//            ;
//        } else {
//            throw new EntityNotFoundException(ERROR_NOT_FOUND, Classroom.class, id);
//        }
//
//    }
//
//    @Override
//    public Optional<Classroom> findClassroomById(long id) {
//        return classroomRepo.findById(id);
//    }
//
//    @Transactional
//    @Override
//    public Classroom saveOrUpdateClassroom(Classroom c) throws EntityNotFoundException {
//        if (c.getId() != 0 && !classroomExists(c.getId())) {
//            throw new EntityNotFoundException(ERROR_NOT_FOUND, Classroom.class, c.getId());
//        }
//        return classroomRepo.save(c);
//    }
//
//    @Override
//    public boolean classroomExists(long id) {
//        return classroomRepo.existsById(id);
//    }
//
//    @Override
//    public Iterable<Course> getAllCourses() {
//        return this.courseRepo.findAll();
//    }
//
//    @Override
//    public void deleteCourse(Course c) throws EntityNotFoundException {
//        if (courseExists(c.getId())) {
//            courseRepo.delete(c);
//        } else {
//            throw new EntityNotFoundException(ERROR_NOT_FOUND, Course.class, c.getId());
//        }
//    }
//
//    @Override
//    public void deleteCourseById(long id) throws EntityNotFoundException {
//        if(courseExists(id)) {
//            courseRepo.deleteById(id);
//        } else {
//            throw new EntityNotFoundException(ERROR_NOT_FOUND, Course.class, id);
//        }
//    }
//
//    @Override
//    public Optional<Course> findCourseById(long id) {
//        return courseRepo.findById(id);
//    }
//
//    @Override
//    public Course saveOrUpdateCourse(Course c) throws EntityNotFoundException {
//        if(c.getId() != 0 && !courseExists(c.getId())) {
//            throw new EntityNotFoundException(ERROR_NOT_FOUND, Course.class, c.getId());
//        } else {
//            return courseRepo.save(c);
//        }
//    }
//
//    @Override
//    public boolean courseExists(long id) {
//        return courseRepo.existsById(id);
//    }

}
