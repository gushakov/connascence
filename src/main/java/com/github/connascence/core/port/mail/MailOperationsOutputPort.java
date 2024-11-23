package com.github.connascence.core.port.mail;

import com.github.connascence.core.model.Student1;

public interface MailOperationsOutputPort {
    void sendCongratulatoryLetter(Student1 student);
}
