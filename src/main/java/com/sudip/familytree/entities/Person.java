package com.sudip.familytree.entities;

import java.util.List;

public class Person {
    private String name;
    private Person husband;
    private Person wife;
    private String gender;
    private List<Person> children;
    private Person father;
    private Person mother;

    private Person(PersonBuilder personBuilder){
        this.name=personBuilder.name;
        this.husband=personBuilder.husband;
        this.wife=personBuilder.wife;
        this.gender=personBuilder.gender;
        this.children=personBuilder.children;
        this.father=personBuilder.father;
        this.mother=personBuilder.mother;
    }




    public static class PersonBuilder{
        private String name;
        private Person husband;
        private Person wife;
        private String gender;
        private List<Person> children;
        private Person father;
        private Person mother;


        public static PersonBuilder newPerson()
        {
            return new PersonBuilder();
        }

        private PersonBuilder() {}

        public PersonBuilder setName(String name){
            this.name=name;
            return this;
        }


        public PersonBuilder setHusband(Person husband){
            this.husband=husband;
            return this;
        }


        public PersonBuilder setFather(Person father){
            this.father=father;
            return this;
        }

        public PersonBuilder setMother(Person mother){
            this.mother=mother;
            return this;
        }

        public PersonBuilder setChildren(List<Person> children){
            this.children=children;
            return this;
        }

        public PersonBuilder setGender(String gender){
            this.gender=gender;
            return this;
        }


        public Person build(){
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "person: "+this.name;
    }
}




