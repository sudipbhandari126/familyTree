package com.sudip.familytree.service;

import org.junit.Before;
import org.junit.Test;

public class PersonServiceTest {
    PersonService personService;

    @Before
    public void init(){
        personService = new PersonService();
        personService.addChild("laxmi","sita","Female");
        personService.addChild("sita","barsha","Female");
    }

    @Test
    public void grandMotherTest(){
        personService.get("barsha").getMother().getMother().equals(personService.get("laxmi"));
    }

}