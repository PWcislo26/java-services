package com.example.studentsmodule.Repository;

import com.example.studentsmodule.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findAllByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findAllByLastName(String lastName);

    List<Student> findAllByFirstName(String lastname);

}
