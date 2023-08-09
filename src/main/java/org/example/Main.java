package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    static Random r = new Random();
    static String[] names = {"Taylor", "Liz","Manny", "Angela", "Christine","Brent","Dave", "Danielle", "Destany", "Dima", "Joe", "Keenen", "Maggie", "Min","Nigel","Osama", "Ricky", "Santos", "Chanelle", "Olamide","Surabhi"};
    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            people.add(randomPersonGen());
        }
        CheckPerson p1 = new CheckPerson() {
            @Override
            public boolean test(Person p) {
                if(p.getAge() > 40 && p.gender == Person.Sex.FEMALE){
                    return true;
                }
                return false;
            }
        };
        CheckPerson check = p -> p.getAge() > 40 && p.gender == Person.Sex.FEMALE;
        Person.printPersons(people, p1);
        Person.printPersons(people, check);
        Predicate<Person> check2 = p -> p.getAge() > 40 && p.gender == Person.Sex.FEMALE;
        people.stream().filter(p -> p.getAge() > 40 && p.gender == Person.Sex.FEMALE).forEach(System.out::println);
        people.stream().filter(check2).forEach(System.out::println);
    }

    private static Person randomPersonGen(){
        String name = names[genNum(names.length)]+genNum(1000);
         return new Person(name,LocalDate.of(genNum(100)+1900,genNum(12) + 1,genNum(29) + 1), Person.Sex.values()[genNum(2)],name + "@aol.com" );
    }

    private static int genNum(int maxNum){
       return r.nextInt(maxNum);
    }


}