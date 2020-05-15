package com.sudip.familytree.relations;

import com.sudip.familytree.entities.Person;

import java.util.Arrays;
import java.util.List;

public class MotherRelationShip implements RelationShip {
    @Override
    public List<Person> forPerson(Person person) {
        return Arrays.asList(person.getMother());
    }
}
