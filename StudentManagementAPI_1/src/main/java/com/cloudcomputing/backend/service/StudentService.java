package com.cloudcomputing.backend.service;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import com.cloudcomputing.backend.model.StudentDTO;
import com.cloudcomputing.backend.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Value("${upload.path}")
    String uploadPath;

    @Value("${home.path}")
    String homeUIPath;

    public StudentDTO addStudent(StudentDTO student, MultipartFile file) {
        try {
            if (file != null && !file.getName().isEmpty()) {
                String fileName = this.generateFileName(file);
                InputStream fileInputStream = file.getInputStream();
                Path path = Paths.get(uploadPath + fileName);
                Files.copy(fileInputStream, path);
                student.setAvatar(homeUIPath + "/student/file/" + fileName);
            }
            StudentDTO st = studentRepository.save(student);
            return st;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<StudentDTO> getAllStudent() {
        return studentRepository.findAll();
    }

    public StudentDTO getStudentById(Integer mssv) {
        StudentDTO st = studentRepository.getByMssv(mssv);
        return st;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }
}