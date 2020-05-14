//package com.sudip.familytree.service;
//
//import com.sudip.familytree.entities.Person;
//import com.sudip.familytree.process.RelationshipFlow;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Arrays;
//
//public class PersonServiceTest {
//    PersonService personService;
//
//    RelationshipFlow relationshipFlow;
//
//    @Before
//    public void init(){
//        relationshipFlow = new RelationshipFlow();
//        personService = new PersonService();
//        personService.addChild("laxmi","sita","Female");
//        personService.addChild("sita","barsha","Female");
//        personService.addChild("sita","bibek","Male");
//        personService.addChild("laxmi","bhawana","Female");
//    }
//
//    @Test
//    public void grandMotherTest(){
//        personService.get("barsha").getMother().getMother().equals(personService.get("laxmi"));
//    }
//
//    @Test
//    public void siblingTest(){
//         assert  personService.get("barsha").getMother()
//                 .getChildren()
//                 .containsAll(Arrays.asList(personService.get("barsha"),personService.get("bibek")));
//    }
//
//    @Test
//    public void barshaIsSisterOfBibek(){
//        Person barsha = personService.get("barsha");
//        Person bibek = personService.get("bibek");
//        personService.findByRelation(barsha,"brother").contains(bibek);
//    }
//
//    @Test
//    public void bhawanaIsMaternalAuntOfBibekAndBarsha(){
//        Person bhawana = personService.get("bhawana");
//        Person barsha = personService.get("barsha");
//        Person bibek = personService.get("bibek");
//
//        assert personService.findByRelation(barsha,"Maternal-Aunt").contains(bhawana);
//        assert personService.findByRelation(bibek,"Maternal-Aunt").contains(bhawana);
//    }
//
//    @Test
//    public void barshaIsDaughterOfSita(){
//        Person barsha = personService.get("barsha");
//        Person sita = personService.get("sita");
//        assert personService.findByRelation(sita,"daughter").contains(barsha);
//
//    }
//
//    @Test
//    public void bibekIsSonOfSita(){
//        Person bibek = personService.get("bibek");
//        Person sita = personService.get("sita");
//        assert personService.findByRelation(sita,"son").contains(bibek);
//    }
//
//    @Test
//    public void maleCannotHaveChildAdded(){
//        String response = personService.addChild("bibek", "ram", "Male");
//        assert response.equals("CHILD_ADDITION_FAILED");
//    }
//
//}