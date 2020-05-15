package com.sudip.familytree.enums;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
    MALE(1, "Male"), FEMALE(2, "Female");
    private Integer ordina;
    private String name;

    Gender(Integer ordina, String name) {
        this.ordina = ordina;
        this.name = name;
    }

    static Map<String, Gender> genderMap;

    static {
        genderMap = new HashMap<>();
        for (Gender value : Gender.values()) {
            genderMap.put(value.name, value);
        }
    }

    public static Gender genderOf(String name) {
        return genderMap.get(name);
    }
}
