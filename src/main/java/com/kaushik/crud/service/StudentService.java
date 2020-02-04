package com.kaushik.crud.service;

import com.kaushik.crud.entity.Student;
import com.kaushik.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student saveOrUpdate(Student student) {
        Student newStudent = studentRepository.save(student);
        return newStudent;
    }

    public Iterable<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student findStudent(Long id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
