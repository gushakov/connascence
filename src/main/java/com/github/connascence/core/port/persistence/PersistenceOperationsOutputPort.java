package com.github.connascence.core.port.persistence;

import com.github.connascence.core.model.Student;

public interface PersistenceOperationsOutputPort {

    void saveStudent(Student student);

    Student loadStudent(Integer studentId);
}
