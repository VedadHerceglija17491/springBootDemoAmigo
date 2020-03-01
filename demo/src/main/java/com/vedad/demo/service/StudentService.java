package com.vedad.demo.service;

import com.vedad.demo.dao.StudentDao;
import com.vedad.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("mongoDB") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persitNewStudent(UUID studentId, Student student) {
        UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
        student.setId(studentId);
        return studentDao.insertNewStudent(studentUid, student);
    }

    public Student getStudentById(UUID studentId) {
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID studentId, Student newStudent) {
        return studentDao.updateStudentById(studentId, newStudent);
    }

    public int deleteStudentById(UUID studentId) {
        return studentDao.deleteStudentById(studentId);
    }
}
