package com.sudip.familytree.service;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.process.RelationshipFlow;
import org.junit.Before;
import org.junit.Test;

import javax.management.relation.Relation;
import java.util.Arrays;
import java.util.List;

public class PersonServiceTest {
    PersonService personService;

    RelationshipFlow relationshipFlow;

    @Before
    public void init(){
        relationshipFlow = new RelationshipFlow();
        personService = new PersonService();
        personService.addChild("laxmi","sita","Female");
        personService.addChild("sita","barsha","Female");
        personService.addChild("sita","bibek","Male");
        personService.addChild("laxmi","bhawana","Female");
    }

    @Test
    public void grandMotherTest(){
        personService.get("barsha").getMother().getMother().equals(personService.get("laxmi"));
    }

    @Test
    public void siblingTest(){
         assert  personService.get("barsha").getMother()
                 .getChildren()
                 .containsAll(Arrays.asList(personService.get("barsha"),personService.get("bibek")));
    }

    @Test
    public void barshaIsSisterOfBibek(){
        Person barsha = personService.get("barsha");
        Person bibek = personService.get("bibek");
        relationshipFlow.findByRelation(barsha,"brother").equals(bibek);
    }

    @Test
    public void bhawanaIsMaternalAuntOfBibekAndBarsha(){
        Person bhawana = personService.get("bhawana");
        Person barsha = personService.get("barsha");
        Person bibek = personService.get("bibek");

        assert relationshipFlow.findByRelation(barsha,"Maternal-Aunt").equals(bhawana);
        assert relationshipFlow.findByRelation(bibek,"Maternal-Aunt").equals(bhawana);
    }

    @Test
    public void barshaIsDaughterOfSita(){
        Person barsha = personService.get("barsha");
        Person sita = personService.get("sita");
        assert relationshipFlow.findByRelation(sita,"daughter").equals(barsha);

    }

    @Test
    public void bibekIsSonOfSita(){
        Person bibek = personService.get("bibek");
        Person sita = personService.get("sita");
        assert relationshipFlow.findByRelation(sita,"son").equals(bibek);

    }

}