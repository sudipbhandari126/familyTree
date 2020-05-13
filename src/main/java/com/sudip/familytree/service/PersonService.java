package com.sudip.familytree.service;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;
import com.sudip.familytree.process.RelationShip;
import com.sudip.familytree.process.RelationshipFlow;

import java.util.Map;
import java.util.Objects;

public class PersonService {
    /*
    Addition to family tree happens via mother

    ADD_CHILD ”Mother’s-Name" "Child's-Name" "Gender"
     */
    PersonPersistenceProvider personPersistenceProvider;
    private Map<String,RelationShip> relationShipMap;

    public PersonService(){
        personPersistenceProvider = new InMemoryPersonPersistenceTemplate();
        RelationshipFlow relationshipFlow = new RelationshipFlow();
        relationShipMap=relationshipFlow.getRelationShipMap();
    }

    public String addChild(String motherName, String childName, String childGender){
        Person mother = personPersistenceProvider.get(motherName);
        if (Objects.isNull(mother)){
            mother = new Person(motherName, Gender.FEMALE);
            personPersistenceProvider.save(mother);
        }
        if (mother.getGender().equals(Gender.MALE)) return "CHILD_ADDITION_FAILED";
        Person child = new Person(childName, Gender.genderOf(childGender));
        child.linkToMother(mother);
        personPersistenceProvider.save(child);
        return "CHILD_ADDITION_SUCCEEDED";
    }

    public Person get(String name){
        return personPersistenceProvider.get(name);
    }

    public Person findByRelation(Person person, String relationship){
        RelationShip relationShip = relationShipMap.get(relationship);
        return relationShip.fetchRelation(person);
    }

    public String findByRelation(String personName, String relationship){
        Person person = personPersistenceProvider.get(personName);
        if (Objects.isNull(person)) return "PERSON_NOT_FOUND";
        RelationShip relationShip = relationShipMap.get(relationship);
        return relationShip.fetchRelation(person).getName();
    }
}
