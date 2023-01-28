package me.joao.springrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handlingException(StudentNotFoundException studentNotFoundException) {
        StudentErrorResponse response = buildStudentErrorResponse(HttpStatus.NOT_FOUND, studentNotFoundException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
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
}
