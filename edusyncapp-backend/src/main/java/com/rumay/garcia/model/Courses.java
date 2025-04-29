package com.rumay.garcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourses;

    @Column(nullable=false, name="nombreCurso", length = 50)
    private String nameCourses;

    @Column(nullable = false, name="Descripcion", length = 100)
    private String description;

    @Column(nullable = false, name ="creditos", length = 10)
    private Integer credits;
}
