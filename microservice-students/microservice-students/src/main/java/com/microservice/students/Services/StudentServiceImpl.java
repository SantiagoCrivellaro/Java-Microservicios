package com.microservice.students.Services;

import com.microservice.students.Entitys.Students;
import com.microservice.students.Persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Students> findAll() {
        return (List<Students>) studentRepository.findAll();
    }

    @Override
    public Students findById(Long id) {
    return studentRepository.findById(id).orElseThrow();

    }

    @Override
    public void save(Students student) {
         studentRepository.save(student);
    }

    @Override
    public List<Students> findByIdCourse(Long idCourse) {
        return studentRepository.findAllStudents(idCourse);
    }
}
