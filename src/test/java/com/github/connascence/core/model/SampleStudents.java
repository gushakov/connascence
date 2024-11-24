package com.github.connascence.core.model;

import java.util.Map;

public class SampleStudents {

    private static Map<Integer, Student> students() {
        return Map.of(
                1,
                Student.builder()
                        .id(1)
                        .graduate(false)
                        .address("Main St. 123")
                        .build()
        );
    }

    public static Student anyStudent(){
        return students().values().stream().findAny().orElseThrow(AssertionError::new);
    }

}
