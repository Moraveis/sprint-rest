package me.joao.springrest.rest;

import me.joao.springrest.entity.Student;
import me.joao.springrest.exceptions.StudentErrorResponse;
import me.joao.springrest.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        this.students = createStudentsStubs();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Integer studentId) {
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student id not found. Id = " + studentId);
        }

        return this.students.get(studentId);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlingException(StudentNotFoundException studentNotFoundException) {
        StudentErrorResponse response = buildStudentErrorResponse(HttpStatus.NOT_FOUND, studentNotFoundException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlingException(Exception exception) {
        StudentErrorResponse response = buildStudentErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    private static StudentErrorResponse buildStudentErrorResponse(HttpStatus notFound, String studentNotFoundException) {
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(notFound.value());
        response.setMessage(studentNotFoundException);
        response.setTimestamp(System.currentTimeMillis());
        return response;
    }

    private List<Student> createStudentsStubs() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mario", "Bros"));
        students.add(new Student("Luigi", "Bros"));
        students.add(new Student("Princess", "Peach"));

        return students;
    }
}
