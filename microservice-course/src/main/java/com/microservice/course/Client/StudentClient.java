package com.microservice.course.Client;


import com.microservice.course.dto.StudentDTO;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-students", url = "localhost:8080/api/students")
public interface StudentClient {


    // Consumir Microservicios de Estudiantes
    @GetMapping("/search-by-course/{idCourse}")
    List<StudentDTO> findAllStudentsByCourse(@PathVariable Long idCourse);

}
