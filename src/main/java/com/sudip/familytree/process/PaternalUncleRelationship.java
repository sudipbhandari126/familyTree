package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;

import java.util.List;
import java.util.stream.Collectors;

public class PaternalUncleRelationship implements RelationShip {
    @Override
    public List<Person> fetchRelation(Person person) {
        return  person.getFather()
                .getChildren()
                .stream()
                .filter(each->each.getGender().equals(Gender.MALE))
                .filter(each->!each.equals(person))
                .collect(Collectors.toList());
    }
}
