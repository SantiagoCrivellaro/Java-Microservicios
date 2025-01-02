package com.microservice.students.Controller;


import com.microservice.students.Entitys.Students;
import com.microservice.students.Services.IStudentService;
import com.microservice.students.Services.StudentServiceImpl;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private IStudentService Studentservice;



    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Students student) {
        Studentservice.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents() {
    return ResponseEntity.ok(Studentservice.findAll());
    }


    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(Studentservice.findById(id));
    }


    // EndPoint para ser consumido desde nuestro microservicio de cursos

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findbyIdCourse( @PathVariable Long idCourse) {
     return ResponseEntity.ok(Studentservice.findByIdCourse(idCourse));

    }
}
