package com.fide.service.impl;

import com.fide.dto.StudentRequestDto;
import com.fide.dto.mapper.MapStructMapper;
import com.fide.model.Student;
import com.fide.repository.StudentRepository;
import com.fide.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private MapStructMapper mapper;
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(MapStructMapper mapper, StudentRepository studentRepository) {
        this.mapper =mapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<StudentRequestDto> save(StudentRequestDto studentRequestDto) {

        studentRepository.save(mapper.studentDtoToStudentEntity(studentRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRequestDto);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Override
    public ResponseEntity<StudentRequestDto> update(Long id, StudentRequestDto studentRequestDto) {
        Student student = mapper.studentDtoToStudentEntity(studentRequestDto);
        student.setId(id);
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentRequestDto);
    }

    @Override
    public ResponseEntity<StudentRequestDto> get(Long id) {
        return new ResponseEntity<>(mapper.studentEntityToDto(studentRepository.findById(id).get()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity patchStudent(Long id, Student student) {
        return null;
    }
}
