package com.fide.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class StudentRequestDto {
    private Long id;
    private String name;
    private String surname;
    private Date birthday;
    private String classYear;
    private String email;
}
