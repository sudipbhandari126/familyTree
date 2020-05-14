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
        String name="NONE";
        try {
            name = relationShip.fetchRelation(person).getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    private String addCouple(String maleName,String femaleName){
        Person maleGuy = personPersistenceProvider.get(maleName);
        if (Objects.isNull(maleGuy)) maleGuy = new Person(maleName, Gender.MALE);
        Person femaleGal = personPersistenceProvider.get(femaleName);
        if (Objects.isNull(femaleGal)) femaleGal = new Person(femaleName, Gender.FEMALE);
        maleGuy.setSpouse(femaleGal);
        return "COUPLE_ADDITION_SUCCEEDED";
    }

    public void loadFamilyTree(){
        //Generation 1
        addCouple("King Shan","Queen Anga");

        //Generation 2
        addCouple("Chit","Amba");
        addChild("Queen Anga","chit","Male");
        addChild("Queen Anga","Ish","Male");
        addCouple("Vich","Lika");
        addChild("Queen Anga","Vich","Male");
        addCouple("Aras","Chitra");
        addChild("Queen Anga","Aras","Male");
        addCouple("Vyan","Satya");
        addChild("Queen Anga","Satya","Female");

        //Generation 3
        addCouple("Jaya","Dritha");
        addChild("Amba","Dritha","Female");
        addChild("Amba","Tritha","Female");
        addChild("Amba","Vritha","Male");
        addChild("Lika","Vila","Female");
        addChild("Lika","Chika","Female");
        addCouple("Arit","Jnki");
        addChild("Chitra","Jnki","Female");
        addChild("Chitra","Ahit","Male");
        addCouple("Asva","Satvy");
        addChild("Satya","Satvy","Female");
        addCouple("Vyas","Krpi");
        addChild("Satya","Vyas","Male");
        addChild("Satya","Atya","Female");

        //GEneration 4
        addChild("Dritha","Yodhan","Male");
        addChild("Jnki","Laki","Male");
        addChild("Jnki","Lavnya","Female");
        addChild("Satvy","Vasa","Male");
        addChild("Krpi","Kriya","Male");
        addChild("Krpi","Krithi","Female");
    }
}
