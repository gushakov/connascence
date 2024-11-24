package com.github.connascence.infrastructure.adapter.db;

import com.github.connascence.core.model.Student;
import org.junit.jupiter.api.Test;

import static com.github.connascence.core.model.SampleStudents.anyStudent;
import static org.mockito.Mockito.*;

public class PersistenceGatewayAdapterTest {

    @Test
    void saving_student_does_not_have_side_effects() {

        /*
            We are using Mockito "spy" to observe any interactions
            with any of the methods of "Student" instance during
            the execution of the "saveStudent" method in the gateway.
         */

        // given
        Student student = spy(anyStudent());

        // when
        new PersistenceGatewayAdapter().saveStudent(student);

        // then
        // other verifications are omitted

        // and
        verify(student, never()).updateAddress(anyString());
        verify(student, never()).updateGraduateStatus();
    }
}
