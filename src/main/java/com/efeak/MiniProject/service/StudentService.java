package com.efeak.MiniProject.service;

import com.efeak.MiniProject.Exception.StudentAlreadyExistException;
import com.efeak.MiniProject.Exception.StudentNotFoundException;
import com.efeak.MiniProject.dto.request.CreateStudentRequestDto;
import com.efeak.MiniProject.mapper.IStudentMapper;
import com.efeak.MiniProject.repository.IStudentRepository;
import com.efeak.MiniProject.repository.entity.Student;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final IStudentRepository studentRepository;
    public Student addStudent(CreateStudentRequestDto dto) {
        if (studentRepository.existsByEmail(dto.getEmail())) {
            throw new StudentAlreadyExistException("Student with email " + dto.getEmail() + " already exists");
        }
        return studentRepository.save(Mappers.getMapper(IStudentMapper.class).toStudent(dto));
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public Student updateStudent(CreateStudentRequestDto dto,Long id){
        return studentRepository.findById(id).map(student1 -> {
            student1.setName(dto.getName());
            student1.setEmail(dto.getEmail());
            student1.setDepartment(dto.getDepartment());
            return studentRepository.save(student1);
        }).orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student with id " + id + " not found"));
    }
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
        studentRepository.deleteById(id);
    }
}
