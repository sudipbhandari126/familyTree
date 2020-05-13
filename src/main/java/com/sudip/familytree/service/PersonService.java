package com.sudip.familytree.service;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;

import java.util.Objects;

public class PersonService {
    /*
    Addition to family tree happens via mother

    ADD_CHILD ”Mother’s-Name" "Child's-Name" "Gender"
     */
    PersonPersistenceProvider personPersistenceProvider;

    PersonService(){
        personPersistenceProvider = new InMemoryPersonPersistenceTemplate();
    }

    public void addChild(String motherName, String childName, String childGender){
        Person mother = personPersistenceProvider.get(motherName);
        if (Objects.isNull(mother)){
            mother = new Person(motherName, Gender.FEMALE);
            personPersistenceProvider.save(mother);
        }
        Person child = new Person(childName, Gender.genderOf(childGender));
        child.linkToMother(mother);
        personPersistenceProvider.save(child);
    }

    public Person get(String name){
        return personPersistenceProvider.get(name);
    }
}
