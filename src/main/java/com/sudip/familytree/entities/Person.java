package com.sudip.familytree.entities;

import com.sudip.familytree.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private Person husband;
    private Person wife;
    private Gender gender;
    private List<Person> children;
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
        children = new ArrayList<>();
    }

    private void setHusband(Person husband) {
        this.husband = husband;
    }

    private void setWife(Person wife) {
        this.wife = wife;
    }

    public void setSpouse(Person spouse) {
        if (Gender.MALE.equals(this.gender)) {
            setWife(spouse);
            spouse.setHusband(this);
        } else {
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

    public boolean isMale() {
        return Gender.MALE.equals(this.gender);
    }

    public boolean isFemale() {
        return Gender.FEMALE.equals(this.gender);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                husband.equals(person.husband) &&
                wife.equals(person.wife) &&
                gender == person.gender &&
                children.equals(person.children) &&
                father.equals(person.father) &&
                mother.equals(person.mother);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, husband, wife, gender, children, father, mother);
    }
}




