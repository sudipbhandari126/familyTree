package com.sudip.familytree.relations;

import com.sudip.familytree.entities.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FatherRelationShip implements RelationShip {
    @Override
    public List<Person> forPerson(Person person) {
        if (Objects.isNull(person.getFather())) return Collections.emptyList();
        return Arrays.asList(person.getFather());
    }
}
