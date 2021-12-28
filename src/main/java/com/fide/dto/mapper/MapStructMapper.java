package com.fide.dto.mapper;

import com.fide.dto.CourseRequestDto;
import com.fide.dto.StudentRequestDto;
import com.fide.model.Course;
import com.fide.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    CourseRequestDto courseEntityToDto(Course course);

    Course courseDtoToCourseEntity(CourseRequestDto courseRequestDto);

    StudentRequestDto studentEntityToDto(Student student);

    Student studentDtoToStudentEntity(StudentRequestDto studentRequestDto);

}
