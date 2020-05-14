package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;

import java.util.List;


public interface RelationShip {
     List<Person> fetchRelation(Person person);

     default String generateNames(List<Person> persons){
          StringBuilder namesBuilder = new StringBuilder();
          for (Person p: persons){
               namesBuilder.append(p.getName());
               namesBuilder.append(" ");
          }
          return namesBuilder.length()==0?"NONE":namesBuilder.substring(0,namesBuilder.length()-1);
     }
}
