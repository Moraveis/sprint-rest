package me.joao.springrest.rest;

import me.joao.springrest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        return createStudentsStubs();
    }

    private List<Student> createStudentsStubs() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mario", "Bros"));
        students.add(new Student("Luigi", "Bros"));
        students.add(new Student("Princess", "Peach"));

        return students;
    }
}
