package com.microservice.students.Persistence;

import com.microservice.students.Entitys.Students;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Students, Long> {

    @Query("SELECT s FROM Students s WHERE s.courseId = :idCourse")
    List<Students> findAllStudents(Long idCourse);


    // List<Students> findAllByCourseId(Long idCourse);
}
