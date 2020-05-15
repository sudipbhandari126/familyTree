package com.sudip.familytree.operations;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyTreeTest {
    private List<Person> persons;


    @Before
    public void init() {
        persons = new ArrayList<>();
        Person ram = new Person("Ram", Gender.MALE);
        Person sita = new Person("Sita", Gender.FEMALE);
        persons = Arrays.asList(ram,sita);
    }

    @Test
    //todo 1. showing valid names, 2. showing NONE for non existing (single name, multiple names)
    public void familyTreeShowsNameOfPersonIsSuccess() {
        String names = FamilyTree.getNames(persons);
        assert names.contains("Ram") && names.contains("Sita");
    }

    @Test
    public void familyTreeShowsNoneIfPersonsListIsEmpty(){
        String names = FamilyTree.getNames(Arrays.asList());
        assert names.equals("NONE");
    }


    @Test
    public void familyTreeShowsPersonNameForSinglePerson(){
        String names = FamilyTree.getNames(Arrays.asList(persons.get(0)));
        assert names.equals("Ram");
    }

}