package com.rumay.garcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;

    @Column(nullable = false, name = "nombreEstudiante", length = 50)
    private String firstName;

    @Column(nullable = false, name = "apellido", length = 50)
    private String lastName;

    @Column(nullable = false, name = "emailEstudiante", length = 50)
    private String email;

    @Column(nullable = false, name = "celular", length = 50)
    private String telefono;

}
