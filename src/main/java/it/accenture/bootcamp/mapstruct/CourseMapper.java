package it.accenture.bootcamp.mapstruct;

import it.accenture.bootcamp.dtos.CourseDTO;
import it.accenture.bootcamp.models.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
    @Mapping(target = "sectorId", source = "sector.id")
    @Mapping(target = "sectorName", source = "sector.name")
    CourseDTO fromCourse (Course c);
    @Mapping(target = "sector.id", source = "sectorId")
    @Mapping(target = "sector.name", source = "sectorName")
    Course toCourse (CourseDTO cDTO);
}