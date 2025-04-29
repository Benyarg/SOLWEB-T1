package com.rumay.garcia.service.impl;

import com.rumay.garcia.repo.IGenericRepo;
import com.rumay.garcia.service.ICoursesService;
import lombok.RequiredArgsConstructor;
import com.rumay.garcia.repo.ICoursesRepo;

import com.rumay.garcia.model.Courses;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl extends GenericsServiceImpl<Courses, Integer> implements ICoursesService {
    private final ICoursesRepo repo;

    @Override
    protected IGenericRepo<Courses, Integer> getRepo() {
        return repo;
    }
}
