package com.efeak.MiniProject.repository;

import com.efeak.MiniProject.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{

    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);
}
