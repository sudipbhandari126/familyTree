package com.sudip.familytree.operations;

import com.sudip.familytree.entities.Person;

import java.util.List;

public class FamilyTree {

    public static String getNames(List<Person> persons) {
        StringBuilder namesBuilder = new StringBuilder();
        for (Person p : persons) {
            namesBuilder.append(p.getName());
            namesBuilder.append(" ");
        }
        return namesBuilder.length() == 0 ? "NONE" : namesBuilder.substring(0, namesBuilder.length() - 1);
    }


}
