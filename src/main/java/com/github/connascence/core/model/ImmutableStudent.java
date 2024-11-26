package com.github.connascence.core.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Simple aggregate (root) modeling a student. This version
 * of the model is immutable. Each business methods returns
 * a copy of the model with modified state.
 */
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ImmutableStudent {

    @EqualsAndHashCode.Include
    final Integer id;

    /*
        These instance variables will never be mutated.
     */

    Boolean graduate;
    String address;

    @Builder
    public ImmutableStudent(Integer id, Boolean graduate, String address) {

        /*
            If we are passed any collections, we need to make sure to
            make local copies of those before assigning them to our
            instance variables.
         */

        this.id = Validate.strictlyPositive(id);
        this.graduate = Validate.notNull(graduate);
        this.address = Validate.notBlank(address);
    }

    /**
     * Returns a copy of this student with {@code graduate} status
     * updated to {@code true}.
     *
     * @return copy of this student with updated graduate status
     */
    public ImmutableStudent updateGraduateStatus() {

        /*
            We oly need to change the attributes of the copy which
            are directly relevant to the business method at hand.
         */
        return newStudent()
                .graduate(true)
                .build();
    }

    /**
     * Returns a copy of this student with updated {@code address}.
     *
     * @param newAddress new address of this student
     * @return copy of this student with new address
     */
    public ImmutableStudent updateAddress(String newAddress) {
        return newStudent()
                .address(newAddress)
                .build();
    }

    /**
     * Helper method which prepares a builder for this {@code ImmutableStudent}
     * instance with the reference to all instance variables.
     *
     * @return builder for the copy of this instance
     */
    private ImmutableStudentBuilder newStudent() {
        return ImmutableStudent.builder()
                .id(this.id)
                .graduate(this.graduate)
                .address(this.address);
    }
}
