package com.github.connascence.infrastructure.adapter.db;

import com.github.connascence.core.model.Student1;
import com.github.connascence.core.port.persistence.PersistenceOperationsOutputPort;
import org.springframework.stereotype.Service;

@Service
public class PersistenceGatewayAdapter implements PersistenceOperationsOutputPort {
    // JdbcTemplate or JPA repository, mapper to DB entities are not shown

    @Override
    public void saveStudent1(Student1 student1) {

        /*
            Let's assume that inadvertently, we change student's address
            before saving it.
         */

        student1.updateAddress("Some new address");

        /*
            Then we proceed to map the domain model to persistence model
            and then to save the latter to the persistence store.
         */

        // map student to a DB entity and save it to the database
    }

    @Override
    public Student1 loadStudent1(Integer studentId) {
        // load student from the database, omitted for clarity
        return null;
    }
}
