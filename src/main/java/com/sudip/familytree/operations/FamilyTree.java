package com.sudip.familytree.operations;

import com.sudip.familytree.entities.Person;

import java.util.List;
import java.util.Objects;

public class FamilyTree {

    public static String getNames(List<Person> persons) {
        if (Objects.isNull(persons)) return "NONE";
        StringBuilder namesBuilder = new StringBuilder();
        for (Person p : persons) {
            if (Objects.nonNull(p.getName())) {
                namesBuilder.append(p.getName());
                namesBuilder.append(" ");
            }
        }
        return namesBuilder.length() == 0 ? "NONE" : namesBuilder.substring(0, namesBuilder.length() - 1);
    }


}
