package com.sudip.familytree.service;

import com.sudip.familytree.entities.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PersonServiceTest {
    PersonService personService;

    @Before
    public void init(){
        personService = new PersonService();
        personService.addChild("laxmi","sita","Female");
        personService.addChild("sita","barsha","Female");
        personService.addChild("sita","bibek","Male");
    }

    @Test
    public void grandMotherTest(){
        personService.get("barsha").getMother().getMother().equals(personService.get("laxmi"));
    }

    @Test
    public void siblingTest(){
         assert  personService.get("barsha").getMother()
                 .getChildren()
                 .containsAll(Arrays.asList(personService.get("barsha"),personService.get("bibek")));
    }

}