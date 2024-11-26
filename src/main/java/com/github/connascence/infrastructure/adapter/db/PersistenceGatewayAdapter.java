package com.github.connascence.infrastructure.adapter.db;

import com.github.connascence.core.model.ImmutableStudent;
import com.github.connascence.core.model.Student;
import com.github.connascence.core.port.persistence.PersistenceOperationsOutputPort;
import org.springframework.stereotype.Service;

@Service
public class PersistenceGatewayAdapter implements PersistenceOperationsOutputPort {
    // JdbcTemplate or JPA repository, mapper to DB entities are not shown

    @Override
    public void saveStudent(Student student) {

        /*
            Let's assume that inadvertently, we change student's address
            before saving it.
         */

        student.updateAddress("Some new address");

        /*
            Then we proceed to map the domain model to persistence model
            and then to save the latter to the persistence store.
         */

        // map student to a DB entity and save it to the database
    }

    @Override
    public void saveStudent(ImmutableStudent student) {
        /*
            If we call this method inadvertently, it will not
            have any impact on the execution of the (caller) use case.
         */

        student.updateAddress("Some new address");

        /*
            Then we proceed to map the domain model to persistence model
            and then to save the latter to the persistence store.
         */

        // map student to a DB entity and save it to the database

    }

    @Override
    public Student loadStudent(Integer studentId) {
        // load student from the database, omitted for clarity
        return null;
    }

    @Override
    public ImmutableStudent loadImmutableStudent(Integer studentId) {
        // load (immutable) student from the database, omitted for clarity
        return null;
    }
}
