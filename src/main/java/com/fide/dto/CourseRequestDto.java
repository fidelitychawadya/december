package com.fide.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseRequestDto {
    private Long id;
    private String courseName;
    private String description;
    private String classCredit;
}
