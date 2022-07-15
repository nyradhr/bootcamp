package it.accenture.bootcamp.mapstruct;

import it.accenture.bootcamp.dtos.CourseDTO;
import it.accenture.bootcamp.models.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
    CourseDTO fromCourse (Course c);
    Course toCourse (CourseDTO cDTO);
}