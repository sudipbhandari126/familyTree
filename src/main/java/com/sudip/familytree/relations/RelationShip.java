package com.sudip.familytree.relations;

import com.sudip.familytree.entities.Person;

import java.util.List;


public interface RelationShip {
    List<Person> forPerson(Person person);
}
