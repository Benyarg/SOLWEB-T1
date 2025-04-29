package com.rumay.garcia.Assembler;

import com.rumay.garcia.DTO.CoursesDTO;
import com.rumay.garcia.controller.CoursesController;
import com.rumay.garcia.model.Courses;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;


@Component
public class CoursesAssembler {
    public EntityModel<CoursesDTO> toModel (Courses courses){
        CoursesDTO coursesDTO = new CoursesDTO(
                courses.getIdCourses(),
                courses.getNameCourses(),
                courses.getDescription(),
                courses.getCredits()
        );
        EntityModel<CoursesDTO> courseResource = EntityModel.of(coursesDTO);

        //Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CoursesController.class).findById(courses.getIdCourses())).withSelfRel();
        //Link updateLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CoursesController.class).update(courses.getIdCourses(), null)).withRel("update");
        //Link deleteLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CoursesController.class).delete(courses.getIdCourses())).withRel("delete");

        Link selfLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(CoursesController.class).getClass()
        ).slash(courses.getIdCourses()).withSelfRel();

        Link updateLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(CoursesController.class).getClass()
        ).slash(courses.getIdCourses()).withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(CoursesController.class).getClass()
        ).slash(courses.getIdCourses()).withRel("delete");

        courseResource.add(selfLink, updateLink, deleteLink);

        return courseResource;
    }
}
