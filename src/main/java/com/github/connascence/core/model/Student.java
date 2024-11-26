package com.github.connascence.core.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Simple aggregate (root) modeling a student. This version
 * of the model is with mutable state which can change through
 * business methods. All instance variables are accessible
 * through public getters.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @EqualsAndHashCode.Include
    final Integer id;

    /*
        These instance variables may be mutated by the public
        business methods below.
     */

    Boolean graduate;
    String address;

    @Builder
    public Student(Integer id, Boolean graduate, String address) {
        this.id = Validate.strictlyPositive(id);
        this.graduate = Validate.notNull(graduate);
        this.address = Validate.notBlank(address);
    }

    /**
     * Changes the graduation status of this student to "graduate".
     * Will mutate the state of this aggregate.
     */
    public void updateGraduateStatus() {
        this.graduate = true;
    }

    /**
     * Updates the address of this student.
     * Will mutate the state of this aggregate.
     *
     * @param newAddress new address of this student
     */
    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }
}
