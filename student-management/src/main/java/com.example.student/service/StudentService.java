
package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedStudent.getName());
            existing.setEmail(updatedStudent.getEmail());
            existing.setCourse(updatedStudent.getCourse());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
