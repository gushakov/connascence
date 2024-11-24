package com.github.connascence.infrastructure.adapter.mail;

import com.github.connascence.core.model.Student;
import com.github.connascence.core.port.mail.MailOperationsOutputPort;
import org.springframework.stereotype.Service;

@Service
public class MailSenderAdapter implements MailOperationsOutputPort {
    @Override
    public void sendCongratulatoryLetter(Student student) {

    }
}
