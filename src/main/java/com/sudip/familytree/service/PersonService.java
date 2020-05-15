package com.sudip.familytree.service;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;
import com.sudip.familytree.operations.FamilyTree;
import com.sudip.familytree.relations.RelationShip;
import com.sudip.familytree.relations.RelationshipFlow;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PersonService {
    /*
    Addition to family tree happens via mother

    ADD_CHILD ”Mother’s-Name" "Child's-Name" "Gender"
     */
    PersonPersistenceProvider personPersistenceProvider;
    private Map<String, RelationShip> relationShipMap;

    public PersonService() {
        personPersistenceProvider = new InMemoryPersonPersistenceTemplate();
        RelationshipFlow relationshipFlow = new RelationshipFlow();
        relationShipMap = relationshipFlow.getRelationShipMap();
    }

    public String addChild(String motherName, String childName, String childGender) {
        Person mother = personPersistenceProvider.get(motherName);
        if (Objects.isNull(mother)) return "PERSON_NOT_FOUND";
        if (mother.getGender().equals(Gender.MALE)) return "CHILD_ADDITION_FAILED";
        Person child = personPersistenceProvider.get(childName);
        if (Objects.isNull(child)) {
            child = new Person(childName, Gender.genderOf(childGender));
        }
        child.linkToMother(mother);
        child.linkToFather(mother.getHusband());
        personPersistenceProvider.save(mother);
        personPersistenceProvider.save(child);
        return "CHILD_ADDITION_SUCCEEDED";
    }

    public Person get(String name) {
        return personPersistenceProvider.get(name);
    }

    public List<Person> findByRelation(Person person, String relationship) {
        RelationShip relationShip = relationShipMap.get(relationship);
        return relationShip.forPerson(person);
    }

    public String findByRelation(String personName, String relationship) {
        Person person = personPersistenceProvider.get(personName);
        if (Objects.isNull(person)) return "PERSON_NOT_FOUND";
        RelationShip relationShip = relationShipMap.get(relationship);
        List<Person> people = relationShip.forPerson(person);
        return FamilyTree.getNames(people);
    }


    public String addCouple(String maleName, String femaleName) {
        Person maleGuy = personPersistenceProvider.get(maleName);
        if (Objects.isNull(maleGuy)) maleGuy = new Person(maleName, Gender.MALE);
        Person femaleGal = personPersistenceProvider.get(femaleName);
        if (Objects.isNull(femaleGal)) femaleGal = new Person(femaleName, Gender.FEMALE);
        maleGuy.setSpouse(femaleGal);
        personPersistenceProvider.save(maleGuy);
        personPersistenceProvider.save(femaleGal);
        return "COUPLE_ADDITION_SUCCEEDED";
    }

    public void loadFamilyTree() {
        //Generation 1
        addCouple("King Shan", "Queen Anga");

        //Generation 2
        addCouple("Chit", "Amba");
        addChild("Queen Anga", "chit", "Male");
        addChild("Queen Anga", "Ish", "Male");
        addCouple("Vich", "Lika");
        addChild("Queen Anga", "Vich", "Male");
        addCouple("Aras", "Chitra");
        addChild("Queen Anga", "Aras", "Male");
        addCouple("Vyan", "Satya");
        addChild("Queen Anga", "Satya", "Female");

        //Generation 3
        addCouple("Jaya", "Dritha");
        addChild("Amba", "Dritha", "Female");
        addChild("Amba", "Tritha", "Female");
        addChild("Amba", "Vritha", "Male");
        addChild("Lika", "Vila", "Female");
        addChild("Lika", "Chika", "Female");
        addCouple("Arit", "Jnki");
        addChild("Chitra", "Jnki", "Female");
        addChild("Chitra", "Ahit", "Male");
        addCouple("Asva", "Satvy");
        addChild("Satya", "Asva", "Male");
        addCouple("Vyas", "Krpi");
        addChild("Satya", "Vyas", "Male");
        addChild("Satya", "Atya", "Female");

        //GEneration 4
        addChild("Dritha", "Yodhan", "Male");
        addChild("Jnki", "Laki", "Male");
        addChild("Jnki", "Lavnya", "Female");
        addChild("Satvy", "Vasa", "Male");
        addChild("Krpi", "Kriya", "Male");
        addChild("Krpi", "Krithi", "Female");
    }
}
