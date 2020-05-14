package com.sudip.familytree.service;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.process.RelationShip;
import com.sudip.familytree.process.RelationshipFlow;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PersonServiceTest {
    PersonService personService;
    PersonPersistenceProvider personPersistenceProvider;

    Map<String, RelationShip> relationShipMap;

    @Before
    public void init(){
        RelationshipFlow relationshipFlow = new RelationshipFlow();
        personService = new PersonService();
        relationShipMap = relationshipFlow.getRelationShipMap();
        personPersistenceProvider = this.personService.personPersistenceProvider;
        personService.loadFamilyTree();
    }

    @Test
    public void isFatherTest(){
        RelationShip father = relationShipMap.get("father");
        List<Person> lika = father.fetchRelation(personPersistenceProvider.get("Vich"));
        String s = father.generateNames(lika);
        assert s.equals("King Shan");
    }


    @Test
    public void siblingsTest(){
        RelationShip father = relationShipMap.get("Siblings");
        List<Person> lika = father.fetchRelation(personPersistenceProvider.get("Dritha"));
        Person tritha = personPersistenceProvider.get("Tritha");
        Person vritha = personPersistenceProvider.get("Vritha");
        assert lika.containsAll(Arrays.asList(tritha,vritha));
    }

    @Test
    public void isMotherTest(){
        RelationShip father = relationShipMap.get("mother");
        List<Person> lika = father.fetchRelation(personPersistenceProvider.get("Jnki"));
        String s = father.generateNames(lika);
        assert s.equals("Chitra");
    }

    @Test
    public void isSisterTest(){
        RelationShip father = relationShipMap.get("sister");
        List<Person> lika = father.fetchRelation(personPersistenceProvider.get("Asva"));
        String s = father.generateNames(lika);
        assert s.contains("Atya");
    }


    @Test
    public void isBrotherTest(){
        RelationShip father = relationShipMap.get("brother");
        List<Person> lika = father.fetchRelation(personPersistenceProvider.get("Vyas"));
        Person asva = personPersistenceProvider.get("Asva");
        assert lika.contains(asva);
    }

    @Test
    public void maternalUncleTest(){
        RelationShip relationShip = relationShipMap.get("Maternal-Uncle");
        List<Person> maternalUncles = relationShip.fetchRelation(personPersistenceProvider.get("Laki"));
        Person ahit = personPersistenceProvider.get("Ahit");
        assert maternalUncles.contains(ahit);
    }


    @Test
    public void maternalAuntTest(){
        RelationShip relationShip = relationShipMap.get("Maternal-Aunt");
        List<Person> maternalAunts = relationShip.fetchRelation(personPersistenceProvider.get("Yodhan"));
        Person tritha = personPersistenceProvider.get("Tritha");
        assert maternalAunts.contains(tritha);
    }


    @Test
    public void sisterInLawTest(){
        RelationShip relationShip = relationShipMap.get("Sister-In-Law");
        List<Person> sistersInLaw = relationShip.fetchRelation(personPersistenceProvider.get("Asva"));
        Person krpi = personPersistenceProvider.get("Krpi");
        assert sistersInLaw.contains(krpi);
    }


    @Test
    public void brotherInLawTest(){
        RelationShip relationShip = relationShipMap.get("Brother-In-Law");
        List<Person> brothersInLaw = relationShip.fetchRelation(personPersistenceProvider.get("Satvy"));
        Person vyas = personPersistenceProvider.get("Vyas");
        assert brothersInLaw.contains(vyas);
    }


    @Test
    public void paternalUncleTest(){
        RelationShip relationShip = relationShipMap.get("Paternal-Uncle");
        List<Person> paternalUncles = relationShip.fetchRelation(personPersistenceProvider.get("Vasa"));
        Person vyas = personPersistenceProvider.get("Vyas");
        assert paternalUncles.contains(vyas);
    }

    @Test
    public void childCanBeAddedToMother(){
        String s = personService.addChild("Krpi", "Pandey", "Female");
        assert s.equals("CHILD_ADDITION_SUCCEEDED");
    }

    @Test(expected = Exception.class)
    public void childCannotBeAddedToSingleMother(){
        String s = personService.addChild("Krithi", "Pandey", "Female");
        assert s.equals("CHILD_ADDITION_SUCCEEDED");
    }

    @Test
    public void childCannotBeAddedToMaleDude(){
        String s = personService.addChild("Ahit", "Pandey", "Female");
        assert s.equals("CHILD_ADDITION_FAILED");
    }

    @Test
    public void childCannotBeAddedToNonExistingMember(){
        String s = personService.addChild("Suresh", "Pandey", "Female");
        assert s.equals("PERSON_NOT_FOUND");
    }




}