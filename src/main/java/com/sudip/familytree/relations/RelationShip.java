package com.sudip.familytree.relations;

import com.sudip.familytree.entities.Person;

import java.util.List;


public interface RelationShip {
    //todo is this a good name? (of)
    List<Person> forPerson(Person person);


}
