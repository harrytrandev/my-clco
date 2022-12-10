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

    public StudentDTO updateStudent(StudentDTO student) {
        StudentDTO oldStudent = studentRepository.getById(student.getMssv());
        if (!student.getFullname().isEmpty() && student.getFullname() != oldStudent.getFullname()) {
            oldStudent.setFullname(student.getFullname());
        }
        if (!student.getClassname().isEmpty() && student.getClassname() != oldStudent.getClassname()) {
            oldStudent.setClassname(student.getClassname());
        }
        if (!student.getSex().isEmpty() && student.getSex() != oldStudent.getSex()) {
            oldStudent.setSex(student.getSex());
        }
        if (student.getGpa() != oldStudent.getGpa()) {
            oldStudent.setGpa(student.getGpa());
        }
        StudentDTO newStudent = studentRepository.save(oldStudent);
        return newStudent;
    }

    public StudentDTO getStudentById(Integer mssv) {
        StudentDTO st = studentRepository.getByMssv(mssv);
        return st;
    }

    public int deleteStudent(int mssv) {
        try {
            StudentDTO studentDTO = getStudentById(mssv);
            studentRepository.delete(studentDTO);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
