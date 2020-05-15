package com.sudip.familytree.relations;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;

import java.util.List;
import java.util.stream.Collectors;

public class BrotherRelationship implements RelationShip {
    @Override
    public List<Person> forPerson(Person person) {
        return person.getFather().getChildren().stream()
                .filter(a -> a.getGender().equals(Gender.MALE) && !a.equals(person))
                .collect(Collectors.toList());
    }
}
