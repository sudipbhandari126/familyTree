package com.sudip.familytree.entities;

import com.sudip.familytree.enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Person husband;
    private Person wife;
    private Gender gender;
    private List<Person> children=new ArrayList<>();
    private Person father;
    private Person mother;

    public String getName() {
        return name;
    }

    public Person getHusband() {
        return husband;
    }

    public Person getWife() {
        return wife;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }



    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    private void setHusband(Person husband) {
        this.husband = husband;
    }

    private void setWife(Person wife) {
        this.wife = wife;
    }

    public void setSpouse(Person spouse){
        if (Gender.MALE.equals(this.gender)){
            setWife(spouse);
            spouse.setHusband(this);
        }else {
            setHusband(spouse);
            spouse.setWife(this);
        }
    }


    public void linkToFather(Person father) {
        this.father = father;
        father.getChildren().add(this);
    }

    public void linkToMother(Person mother) {
        this.mother = mother;
        mother.getChildren().add(this);
    }

    @Override
    public String toString() {
        return "person: "+this.name;
    }
}




