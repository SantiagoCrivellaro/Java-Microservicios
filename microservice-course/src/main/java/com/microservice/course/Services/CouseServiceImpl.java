package com.microservice.course.Services;


import com.microservice.course.Client.StudentClient;
import com.microservice.course.Persistence.CourseRepository;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouseServiceImpl implements ICourseService {


    @Autowired
    private CourseRepository repository;

    @Autowired
    private StudentClient client;


    @Override
    public List<Course> findAll() {
        return (List<Course>) repository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        repository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        // Consultar el curso

        Course course = repository.findById(idCourse).orElse(new Course());

        // Obtener los estudiantes

        List<StudentDTO> studentDTOList = client.findAllStudentsByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
