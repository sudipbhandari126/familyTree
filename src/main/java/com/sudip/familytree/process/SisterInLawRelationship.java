package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SisterInLawRelationship implements RelationShip {
    @Override
    public List<Person> fetchRelation(Person person) {
        List<Person> sistersInLaw = new ArrayList<>();
        if (person.isMale()){
            //brother's wives
            List<Person> wifesBrothers = null;
            try {
                wifesBrothers = person.getFather().getChildren()
                        .stream()
                        .filter(a -> a.isMale() && !a.equals(person))
                        .map(b->b.getWife())
                        .collect(Collectors.toList());
            } catch (Exception e) {
                //
            }
            //wives brothers
            List<Person> sistersHusband = null;
            try {
                sistersHusband = person.getWife().getFather().getChildren()
                        .stream()
                        .filter(a -> a.isMale())
                        .collect(Collectors.toList());
            } catch (Exception e) {
                //
            }
           if (Objects.nonNull(wifesBrothers)) sistersInLaw.addAll(wifesBrothers);
           if (Objects.nonNull(sistersHusband)) sistersInLaw.addAll(sistersHusband);
        } else if (person.isFemale()){
            //husband's sisters
            List<Person> husbandsSisters = null;
            try {
                husbandsSisters = person.getHusband().getFather().getChildren()
                        .stream()
                        .filter(Objects::nonNull)
                        .filter(a -> a.isFemale())
                        .collect(Collectors.toList());
            } catch (Exception e) {
                //
            }
            //brother's wives
            List<Person> brothersWives = null;
            try {
                brothersWives = person.getFather().getChildren()
                        .stream()
                        .filter(Objects::nonNull)
                        .filter(a -> a.isMale())
                        .map(b->b.getWife())
                        .collect(Collectors.toList());
            } catch (Exception e) {
                //
            }
            if (Objects.nonNull(husbandsSisters))sistersInLaw.addAll(husbandsSisters);
            if (Objects.nonNull(brothersWives)) sistersInLaw.addAll(brothersWives);
        }
        return  sistersInLaw;
    }
}
