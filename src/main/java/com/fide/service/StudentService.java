package com.fide.service;

import com.fide.dto.StudentRequestDto;
import com.fide.model.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<StudentRequestDto> save(StudentRequestDto student);

    ResponseEntity<?> delete(Long id);

    ResponseEntity<StudentRequestDto> update(Long id, StudentRequestDto studentRequestDto);

    ResponseEntity<StudentRequestDto> get(Long id);

    ResponseEntity patchStudent(Long id, Student student);
}
