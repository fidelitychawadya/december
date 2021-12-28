package com.fide.repository;

import com.fide.model.CourseStudentRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRelRepository  extends JpaRepository<CourseStudentRelationship, Long> {
}
