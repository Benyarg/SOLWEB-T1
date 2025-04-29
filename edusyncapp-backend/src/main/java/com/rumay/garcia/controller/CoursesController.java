package com.rumay.garcia.controller;

import com.rumay.garcia.Assembler.CoursesAssembler;
import com.rumay.garcia.DTO.CoursesDTO;
import com.rumay.garcia.model.Courses;
import com.rumay.garcia.service.ICoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cursos")
public class CoursesController {
    private final ICoursesService service;
    private final CoursesAssembler assembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<CoursesDTO>>> findAll() throws Exception{
    List<Courses> list= service.findAll();
        List<EntityModel<CoursesDTO>> coursesResource = list.stream()
                .map(courses -> assembler.toModel(courses))
                .toList();
        return ResponseEntity.ok(CollectionModel.of(coursesResource));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CoursesDTO>> findById(@PathVariable("id") Integer id) throws Exception {
        Courses cur = service.findById(id);
        EntityModel<CoursesDTO> coursesResource = assembler.toModel(cur);
        return ResponseEntity.ok(coursesResource);
    }

    @PostMapping
    public ResponseEntity<Courses> save(@RequestBody Courses courses) throws Exception {
        Courses cur = service.save(courses);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cur.getIdCourses()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<CoursesDTO>> update(@PathVariable("id") Integer id, @RequestBody Courses courses) throws Exception {
        Courses cur = service.update(courses, id);
        EntityModel<CoursesDTO> courseResource = assembler.toModel(cur);
        return ResponseEntity.ok(courseResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
