package com.github.connascence.core.port.persistence;

import com.github.connascence.core.model.Student1;

public interface PersistenceOperationsOutputPort {

    void saveStudent1(Student1 student1);

    Student1 loadStudent1(Integer studentId);
}
