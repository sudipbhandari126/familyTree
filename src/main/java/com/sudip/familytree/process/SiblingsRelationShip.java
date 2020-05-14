package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;

import java.util.List;
import java.util.stream.Collectors;

public class SiblingsRelationShip implements RelationShip {
    @Override
    public List<Person> fetchRelation(Person person) {
        return person.getFather().getChildren().stream()
                .filter(a->!a.equals(person))
                .collect(Collectors.toList());
    }
}
