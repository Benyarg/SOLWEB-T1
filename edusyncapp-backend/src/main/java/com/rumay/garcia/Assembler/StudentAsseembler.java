package com.rumay.garcia.Assembler;

import com.rumay.garcia.DTO.StudentDTO;
import com.rumay.garcia.controller.StudentController;
import com.rumay.garcia.model.Student;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class StudentAsseembler {
    public EntityModel<StudentDTO> toModel (Student student){
        StudentDTO studentDTO = new StudentDTO(
                student.getIdStudent(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getTelefono()
        );
        EntityModel<StudentDTO> studentResource = EntityModel.of(studentDTO);
        Link selfLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(StudentController.class).getClass()
        ).slash(student.getIdStudent()).withSelfRel();

        Link updateLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(StudentController.class).getClass()
        ).slash(student.getIdStudent()).withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(StudentController.class).getClass()
        ).slash(student.getIdStudent()).withRel("delete");

        studentResource.add(selfLink, updateLink, deleteLink);

        return studentResource;
    }
}
