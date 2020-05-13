package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;

import java.util.HashMap;
import java.util.Map;

public class RelationshipFlow {
    private Map<String,RelationShip> relationShipMap;

    public RelationshipFlow(){
        relationShipMap = new HashMap<>();
        relationShipMap.put("father",person->person.getFather());
        relationShipMap.put("mother",person -> person.getMother());

        relationShipMap.put("sister", person -> person.getMother().getChildren().stream()
                .filter(each->each.getGender().equals(Gender.FEMALE))
                .findFirst().get());

        relationShipMap.put("brother", person -> person.getMother().getChildren().stream()
                .filter(each->each.getGender().equals(Gender.MALE))
                .findFirst().get());
    }


    public Person findByRelation(Person person, String relationship){
        RelationShip relationShip = relationShipMap.get(relationship);
        return relationShip.fetchRelation(person);
    }

}
