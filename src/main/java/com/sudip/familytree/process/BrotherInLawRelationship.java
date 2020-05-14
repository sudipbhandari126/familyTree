package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BrotherInLawRelationship implements RelationShip {
    @Override
    public List<Person> fetchRelation(Person person) {
        List<Person> brothersInLaw=new ArrayList<>();
        if (person.isMale()){
            //wife's brothers
            List<Person> wifesBrothers = null;
            try {
                wifesBrothers = person.getWife().getFather().getChildren()
                        .stream()
                        .filter(a -> a.isMale())
                        .collect(Collectors.toList());
            } catch (Exception e) {
                //
            }
            //sister's husband
            List<Person> sistersHusband = null;
            try {
                sistersHusband = person.getFather().getChildren()
                        .stream()
                        .filter(a -> a.isFemale())
                        .map(b -> b.getHusband())
                        .collect(Collectors.toList());
            } catch (Exception e) {
                //
            }
           if (Objects.nonNull(wifesBrothers)) brothersInLaw.addAll(wifesBrothers);
           if (Objects.nonNull(sistersHusband)) brothersInLaw.addAll(sistersHusband);
        } else if (person.isFemale()){
            //sisters husband
            List<Person> sistersHusband = null;
            try {
                sistersHusband = person.getFather().getChildren()
                        .stream()
                        .filter(a -> a.isFemale() && !a.equals(person))
                        .map(b -> b.getHusband())
                        .collect(Collectors.toList());
            } catch (Exception e) {
                //
            }
            //husbands brother
            List<Person> husbandsBrothers = null;
            try {
                husbandsBrothers = person.getHusband().getFather().getChildren()
                        .stream()
                        .filter(a -> a.isMale() && !a.equals(person.getHusband()))
                        .collect(Collectors.toList());
            } catch (Exception e) {
                //
            }
           if(Objects.nonNull(sistersHusband)) brothersInLaw.addAll(sistersHusband);
           if(Objects.nonNull(husbandsBrothers)) brothersInLaw.addAll(husbandsBrothers);
        }
        return  brothersInLaw;
    }

}
