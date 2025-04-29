package com.rumay.garcia.controller;

import com.rumay.garcia.Assembler.StudentAsseembler;
import com.rumay.garcia.DTO.StudentDTO;
import com.rumay.garcia.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rumay.garcia.model.Student;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estudiante")
public class StudentController {
    private final IStudentService service;
    private final StudentAsseembler assembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<StudentDTO>>> findAll() throws Exception{
        List<Student> list= service.findAll();
        List<EntityModel<StudentDTO>> studentsResource = list.stream()
                .map(student -> assembler.toModel(student))
                .toList();
        return ResponseEntity.ok(CollectionModel.of(studentsResource));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> findById(@PathVariable("id") Integer id) throws Exception {
        Student est = service.findById(id);
        EntityModel<StudentDTO> studentsResource = assembler.toModel(est);
        return ResponseEntity.ok(studentsResource);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) throws Exception{
        Student est = service.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(est.getIdStudent()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> update(@PathVariable("id") Integer id, @RequestBody Student student) throws Exception {
        Student est = service.update(student, id);
        EntityModel<StudentDTO> courseResource = assembler.toModel(est);
        return ResponseEntity.ok(courseResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
