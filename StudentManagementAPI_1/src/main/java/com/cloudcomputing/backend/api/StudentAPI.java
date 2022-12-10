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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/student")
public class StudentAPI {
    @Autowired
    private StudentService studentService;
    @Value("${upload.path}")
    String uploadPath;

    @PostMapping("/add")
    public StudentDTO addStudent(@RequestPart("student") StudentDTO student, @RequestPart("file") @Nullable MultipartFile file) {
        return studentService.addStudent(student, file);
    }

    @GetMapping("/getAll")
    public List<StudentDTO> getAllStudent() {
        List<StudentDTO> students = studentService.getAllStudent();
        return students.size() > 0 ? students : null;
    }

    @GetMapping("/getById/{mssv}")
    public StudentDTO getStudentById(@PathVariable Integer mssv) {
        StudentDTO st = studentService.getStudentById(mssv);
        return st;
    }

    @GetMapping("/file/{fileName}")
    public ResponseEntity<?> getFile(@PathVariable("fileName") String fileName) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(uploadPath + fileName));
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
        } catch (IOException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}