package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;

import java.util.List;
import java.util.stream.Collectors;

public class MaternalAuntRelationship implements RelationShip {
    @Override
    public List<Person> fetchRelation(Person person) {
        return  person.getMother().getMother()
                .getChildren().stream()
                .filter(each -> each.getGender().equals(Gender.FEMALE))
                .filter(each->!each.equals(person.getMother()))
                .collect(Collectors.toList());
    }
}
