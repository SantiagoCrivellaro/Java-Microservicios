package com.microservice.students.Services;

import com.microservice.students.Entitys.Students;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IStudentService {

    List<Students> findAll();

    Students findById(Long id);

     void save(Students student);


    List<Students> findByIdCourse(Long idCourse);

}
