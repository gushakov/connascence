package com.github.connascence.core.port.persistence;

import com.github.connascence.core.model.ImmutableStudent;
import com.github.connascence.core.model.Student;

public interface PersistenceOperationsOutputPort {

    void saveStudent(Student student);

    void saveStudent(ImmutableStudent student);

    Student loadStudent(Integer studentId);

    ImmutableStudent loadImmutableStudent(Integer studentId);
}
