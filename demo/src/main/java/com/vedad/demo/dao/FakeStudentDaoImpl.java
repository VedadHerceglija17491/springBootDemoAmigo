package com.vedad.demo.dao;

import com.vedad.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao {
    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl(Map<UUID, Student> database) {
        this.database = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        this.database.put(uuid, new Student(uuid,22,"Vedad", "Herceglija", "OOI"));
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
