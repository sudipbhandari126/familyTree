package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;

import java.util.HashMap;
import java.util.Map;

public class RelationshipFlow {
    private Map<String,RelationShip> relationShipMap;

    public RelationshipFlow(){
        relationShipMap = new HashMap<>();
        RelationShip fatherRelationShip = person -> person.getFather();
        RelationShip motherRelationship = person -> person.getMother();
        RelationShip sisterRelationShip = person -> person.getMother().getChildren().stream()
                .filter(each -> each.getGender().equals(Gender.FEMALE))
                .findAny().get();
        RelationShip brotherRelationship = person -> person.getMother().getChildren().stream()
                .filter(each -> each.getGender().equals(Gender.MALE))
                .findAny().get();
        RelationShip maternalAuntRelationship = person -> person.getMother().getMother()
                .getChildren().stream()
                .filter(each -> each.getGender().equals(Gender.FEMALE))
                .filter(each->!each.equals(person.getMother()))
                .findAny().get();
        RelationShip sonRelationship = person -> person.getChildren().stream()
                .filter(each->each.getGender().equals(Gender.MALE))
                .findAny().get();
        RelationShip daughterRelationShip = person -> person.getChildren().stream()
                .filter(each->each.getGender().equals(Gender.FEMALE))
                .findAny().get();
        RelationShip paternalUncle = person -> person.getFather().getFather()
                .getChildren()
                .stream()
                .filter(each->each.getGender().equals(Gender.MALE))
                .filter(each->!each.equals(person))
                .findAny().get();
        RelationShip paternalAunt = person -> person.getFather().getFather()
                .getChildren().stream()
                .filter(each->each.getGender().equals(Gender.FEMALE))
                .findAny().get();
        RelationShip maternalUncle = person -> person.getMother().getMother()
                .getChildren().stream()
                .filter(each->each.getGender().equals(Gender.MALE))
                .findAny().get();
        RelationShip sisterInLaw = person -> person.getWife()
                .getMother()
                .getChildren().stream()
                .filter(each->each.getGender().equals(Gender.FEMALE))
                .findAny().get();

        RelationShip brotherInLaw = person -> person.getHusband()
                .getMother()
                .getChildren().stream()
                .filter(each->each.getGender().equals(Gender.MALE))
                .findAny().get();




        relationShipMap.put("father", fatherRelationShip);
        relationShipMap.put("mother", motherRelationship);
        relationShipMap.put("sister", sisterRelationShip);
        relationShipMap.put("brother", brotherRelationship);
        relationShipMap.put("Maternal-Aunt",maternalAuntRelationship);
        relationShipMap.put("son",sonRelationship);
        relationShipMap.put("daughter",daughterRelationShip);
        relationShipMap.put("Paternal-Uncle",paternalUncle);
        relationShipMap.put("Paternal-Aunt",paternalAunt);
        relationShipMap.put("Maternal-Uncle",maternalUncle);
        relationShipMap.put("Sister-In-Law",sisterInLaw);
        relationShipMap.put("Brother-In-Law",brotherInLaw);





    }

    public Map<String, RelationShip> getRelationShipMap() {
        return relationShipMap;
    }
}
