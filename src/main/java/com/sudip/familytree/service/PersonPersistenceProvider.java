package com.sudip.familytree.service;

import com.sudip.familytree.entities.Person;

public interface PersonPersistenceProvider {
     Person save(Person person);
     Person get(String name);
     boolean delete(String name);
}
