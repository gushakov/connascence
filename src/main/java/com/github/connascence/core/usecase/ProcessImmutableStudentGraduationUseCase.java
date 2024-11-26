package com.github.connascence.core.usecase;

import com.github.connascence.core.model.ImmutableStudent;
import com.github.connascence.core.port.mail.MailOperationsOutputPort;
import com.github.connascence.core.port.persistence.PersistenceOperationsOutputPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProcessImmutableStudentGraduationUseCase implements ProcessStudentGraduationInputPort {

    ProcessStudentGraduationPresenterOutputPort presenter;
    PersistenceOperationsOutputPort persistenceOps;
    MailOperationsOutputPort mailOps;

    @Override
    public void registerGraduation(Integer studentId) {

        // omit security and transaction management for clarity

        // load the student aggregate instance
        ImmutableStudent student = persistenceOps.loadImmutableStudent(studentId);

        /*
            Perform business logic related to the registration of student's
            graduation status. We are receiving a modified copy.
         */

        ImmutableStudent graduatedStudent = student.updateGraduateStatus();

        // save the student
        persistenceOps.saveStudent(graduatedStudent);

        /*
            Execution of "saveStudent" method above will not have any
            effect on the state of "graduatedStudent" object since
            it is immutable by design.
         */

        mailOps.sendCongratulatoryLetter(graduatedStudent);

        // present success
        presenter.presentSuccessfulResultOfStudentGraduationStatusUpdate(student.getId());
    }
}
