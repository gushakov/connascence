package com.github.connascence.core.port.mail;

import com.github.connascence.core.model.ImmutableStudent;
import com.github.connascence.core.model.Student;

public interface MailOperationsOutputPort {
    void sendCongratulatoryLetter(Student student);

    void sendCongratulatoryLetter(ImmutableStudent student);
}
