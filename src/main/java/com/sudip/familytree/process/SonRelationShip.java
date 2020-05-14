package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SonRelationShip implements RelationShip {
    @Override
    public List<Person> fetchRelation(Person person) {
        return person.getChildren()
                .stream()
                .filter(a->a.getGender().equals(Gender.MALE))
                .collect(Collectors.toList());

    }
}
