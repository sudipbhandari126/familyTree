package com.sudip.familytree.service;

import com.sudip.familytree.entities.Person;

import java.util.HashMap;
import java.util.Map;

public class InMemoryPersonPersistenceTemplate  implements PersonPersistenceProvider{
    private Map<String,Person> personMap = new HashMap<String,Person>();

    @Override
    public Person save(Person person) {
        synchronized (person){
            personMap.put(person.getName(),person);
        }
        return person;
    }

    @Override
    public Person get(String name) {
        return personMap.get(name);
    }

    @Override
    public boolean delete(String name) {
        personMap.remove(name);
        return true;
    }
}
