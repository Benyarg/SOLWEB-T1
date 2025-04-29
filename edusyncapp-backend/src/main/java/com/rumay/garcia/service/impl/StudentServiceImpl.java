package com.rumay.garcia.service.impl;

import com.rumay.garcia.model.Student;
import com.rumay.garcia.repo.IGenericRepo;
import com.rumay.garcia.repo.IStudentRepo;
import com.rumay.garcia.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends GenericsServiceImpl<Student, Integer> implements IStudentService {
    private final IStudentRepo rep;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return rep;
    }
}
