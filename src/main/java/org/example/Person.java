package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthday, currentDate).getYears();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Birthday: ").append(birthday.toString()).append("\n");
        sb.append("Current Age: ").append(this.getAge()).append("\n");
        sb.append("Sex: ").append(gender).append("\n");
        sb.append("Email Address: ").append(emailAddress).append("\n");
        return sb.toString();
    }

    public void printPerson(){
        System.out.println(this);
    }

    public static void printPersons(ArrayList<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
