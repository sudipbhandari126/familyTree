package com.sudip.familytree.relations;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;

import java.util.List;
import java.util.stream.Collectors;

public class DaughterRelationShip implements RelationShip {
    @Override
    public List<Person> forPerson(Person person) {
        return person.getChildren()
                .stream()
                .filter(a -> a.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

    }
}
