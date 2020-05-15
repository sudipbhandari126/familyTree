package com.sudip.familytree.relations;

import com.sudip.familytree.entities.Person;

import java.util.List;
import java.util.stream.Collectors;

public class SiblingsRelationShip implements RelationShip {
    @Override
    public List<Person> forPerson(Person person) {
        return person.getFather().getChildren().stream()
                .filter(a -> !a.equals(person))
                .collect(Collectors.toList());
    }
}
