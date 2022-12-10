package com.cloudcomputing.backend.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.cloudcomputing.backend.model.StudentDTO;
import com.cloudcomputing.backend.service.StudentService;
import com.sun.istack.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/student/")
public class StudentAPI {
    @Autowired
    private StudentService studentService;

    @PutMapping("update")
    public StudentDTO updateStudent(@RequestBody StudentDTO student) {
        StudentDTO newStudent = studentService.updateStudent(student);
        return newStudent;
    }

    @DeleteMapping("delete/{mssv}")
    public int deleteStudent(@PathVariable Integer mssv) {
        return studentService.deleteStudent(mssv);
    }
}
