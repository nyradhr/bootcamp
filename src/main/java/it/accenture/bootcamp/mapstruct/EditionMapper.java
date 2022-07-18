package it.accenture.bootcamp.mapstruct;

import it.accenture.bootcamp.dtos.CourseDTO;
import it.accenture.bootcamp.dtos.EditionDTO;
import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.models.Edition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditionMapper {
    EditionMapper INSTANCE = Mappers.getMapper(EditionMapper.class);

    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "courseTitle", source = "course.title")
    @Mapping(target = "tutorId", source = "tutor.id")
    @Mapping(target = "tutorName", source = "tutor.name")
    @Mapping(target = "tutorSurname", source = "tutor.surname")
    EditionDTO fromEdition (Edition e);

    @Mapping(target = "course.id", source = "courseId")
    @Mapping(target = "course.title", source = "courseTitle")
    @Mapping(target = "tutor.id", source = "tutorId")
    @Mapping(target = "tutor.name", source = "tutorName")
    @Mapping(target = "tutor.surname", source = "tutorSurname")
    Edition toEdition (EditionDTO eDTO);
}
