package com.sudip.familytree.service;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.operations.FamilyTree;
import com.sudip.familytree.relations.RelationShip;
import com.sudip.familytree.relations.RelationshipFlow;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FamilyServiceTest {
    FamilyService familyService;
    PersonPersistenceProvider personPersistenceProvider;

    Map<String, RelationShip> relationShipMap;

    //todo 1. add tests for happy case, error, corner/edge case, rename the methods
    //get all uncles (paternal + maternal)

    @Before
    public void init() {
        RelationshipFlow relationshipFlow = new RelationshipFlow();
        familyService = new FamilyService();
        relationShipMap = relationshipFlow.getRelationShipMap();
        personPersistenceProvider = this.familyService.personPersistenceProvider;
        familyService.loadFamilyTree();
    }

    @Test
    public void testFatherelationForVichExpectedKingShan() {
        RelationShip father = relationShipMap.get("father");
        List<Person> lika = father.forPerson(personPersistenceProvider.get("Vich"));
        String s = FamilyTree.getNames(lika);
        assert s.equals("King Shan");
    }


    @Test
    public void testSiblingsRelationForDrithaExpectedTrithaAndVritha() {
        RelationShip father = relationShipMap.get("Siblings");
        List<Person> lika = father.forPerson(personPersistenceProvider.get("Dritha"));
        Person tritha = personPersistenceProvider.get("Tritha");
        Person vritha = personPersistenceProvider.get("Vritha");
        assert lika.containsAll(Arrays.asList(tritha, vritha));
    }

    @Test
    public void testMotherRelationshipForJnkiExpectedChitra() {
        RelationShip father = relationShipMap.get("mother");
        List<Person> lika = father.forPerson(personPersistenceProvider.get("Jnki"));
        String s = FamilyTree.getNames(lika);
        assert s.equals("Chitra");
    }

    @Test
    public void testSisterRelationshipForAsvaExpectedAtya() {
        RelationShip sister = relationShipMap.get("sister");
        List<Person> lika = sister.forPerson(personPersistenceProvider.get("Asva"));
        String s = FamilyTree.getNames(lika);
        assert s.contains("Atya");
    }


    @Test
    public void testBrotherRelationshipForVyasExpectedAsva() {
        RelationShip father = relationShipMap.get("brother");
        List<Person> lika = father.forPerson(personPersistenceProvider.get("Vyas"));
        Person asva = personPersistenceProvider.get("Asva");
        assert lika.contains(asva);
    }

    @Test
    public void testMaternalUncleRelationshipforLakiExpectedAhit() {
        RelationShip relationShip = relationShipMap.get("Maternal-Uncle");
        List<Person> maternalUncles = relationShip.forPerson(personPersistenceProvider.get("Laki"));
        Person ahit = personPersistenceProvider.get("Ahit");
        assert maternalUncles.contains(ahit);
    }


    @Test
    public void testMaternalAuntRelationshipForYodhanExpectedTritha() {
        RelationShip relationShip = relationShipMap.get("Maternal-Aunt");
        List<Person> maternalAunts = relationShip.forPerson(personPersistenceProvider.get("Yodhan"));
        Person tritha = personPersistenceProvider.get("Tritha");
        assert maternalAunts.contains(tritha);
    }


    @Test
    public void testSisterInLawRelationshipForAsvaExpectedKrpi() {
        RelationShip relationShip = relationShipMap.get("Sister-In-Law");
        List<Person> sistersInLaw = relationShip.forPerson(personPersistenceProvider.get("Asva"));
        Person krpi = personPersistenceProvider.get("Krpi");
        assert sistersInLaw.contains(krpi);
    }


    @Test
    public void testBrotherInLawRelationshipForSatvyExpectedVyas() {
        RelationShip relationShip = relationShipMap.get("Brother-In-Law");
        List<Person> brothersInLaw = relationShip.forPerson(personPersistenceProvider.get("Satvy"));
        Person vyas = personPersistenceProvider.get("Vyas");
        assert brothersInLaw.contains(vyas);
    }


    @Test
    public void testPaternalUncleRelationshipForVasaExpectedVyas() {
        RelationShip relationShip = relationShipMap.get("Paternal-Uncle");
        List<Person> paternalUncles = relationShip.forPerson(personPersistenceProvider.get("Vasa"));
        Person vyas = personPersistenceProvider.get("Vyas");
        assert paternalUncles.contains(vyas);
    }

    @Test
    public void testChildCanBeAddedToMotherIsSuccess() {
        String s = familyService.addChild("Krpi", "Pandey", "Female");
        assert s.equals("CHILD_ADDITION_SUCCEEDED");
    }

    @Test(expected = Exception.class)
    public void testChildCannotBeAddedToSingleMotherThrowsException() {
        String s = familyService.addChild("Krithi", "Pandey", "Female");
        assert s.equals("CHILD_ADDITION_SUCCEEDED");
    }

    @Test
    public void testChildCannotBeAddedToMaleReturnsErrorMessage() {
        String s = familyService.addChild("Ahit", "Pandey", "Female");
        assert s.equals("CHILD_ADDITION_FAILED");
    }

    @Test
    public void testChildCannotBeAddedToNonExistingMemberThrowsErrorCode() {
        String s = familyService.addChild("Suresh", "Pandey", "Female");
        assert s.equals("PERSON_NOT_FOUND");
    }


    @Test
    public void testAddCoupleRelationShipReturnsSuccessMessage() {
        String s = familyService.addCouple("ram", "sita");
        assert (s.equals("COUPLE_ADDITION_SUCCEEDED"));
    }

    @Test
    public void testFatherRelationshipForKingShanReturnsNone(){
        RelationShip relationShip = relationShipMap.get("father");
        List<Person> father = relationShip.forPerson(personPersistenceProvider.get("King Shan"));
        assert FamilyTree.getNames(father).equals("NONE");
    }


}