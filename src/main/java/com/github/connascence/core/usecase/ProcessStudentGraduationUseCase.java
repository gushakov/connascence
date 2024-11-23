package com.github.connascence.core.usecase;

import com.github.connascence.core.model.Student1;
import com.github.connascence.core.port.mail.MailOperationsOutputPort;
import com.github.connascence.core.port.persistence.PersistenceOperationsOutputPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProcessStudentGraduationUseCase implements ProcessStudentGraduationInputPort {

    ProcessStudentGraduationPresenterOutputPort presenter;
    PersistenceOperationsOutputPort persistenceOps;
    MailOperationsOutputPort mailOps;

    @Override
    public void registerGraduation(Integer studentId) {

        // omit security and transaction management for clarity

        // load the student aggregate instance
        Student1 student = persistenceOps.loadStudent1(studentId);

        /*
            Perform business logic related to the registration of student's
            graduation status.
         */

        student.updateGraduateStatus();

        // save the student
        persistenceOps.saveStudent1(student);

        /*
            Important: the address of the student has been (inadvertently) changed
            by the persistence adapter (called above), without us being aware of
            this here. Performing any other logic which require the student's address
            will probably not work as expected.
            This is an example of connascence of state, a form of coupling, between
            two software components in Object-Oriented design.
         */

        mailOps.sendCongratulatoryLetter(student);

        // present success
        presenter.presentSuccessfulResultOfStudentGraduationStatusUpdate(student.getId());
    }
}
