package org.example;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {


    @Test
    public void testLambda(){
        List<Person> people = new ArrayList<>();
        LocalDate.of(1990,1,12);
        for(int i = 0; i < 4; i++) {
            people.add(new Person("Jake", LocalDate.of(1990 - (10 * i), 1 + i, 12), Person.Sex.MALE, "test@gmail.com"));
        }

    }

}