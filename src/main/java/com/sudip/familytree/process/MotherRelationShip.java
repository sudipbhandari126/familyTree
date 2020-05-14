package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;

import java.util.Arrays;
import java.util.List;

public class MotherRelationShip implements RelationShip {
    @Override
    public List<Person> fetchRelation(Person person) {
        return Arrays.asList(person.getMother());
    }
}