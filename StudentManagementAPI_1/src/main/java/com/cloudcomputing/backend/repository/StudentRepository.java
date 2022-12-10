package com.cloudcomputing.backend.repository;

import com.cloudcomputing.backend.model.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDTO,Integer> {
    StudentDTO getByMssv(Integer mssv);
}
