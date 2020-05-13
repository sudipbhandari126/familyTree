package com.sudip.familytree.process;

import com.sudip.familytree.entities.Person;
import com.sudip.familytree.enums.Gender;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class FetchFamilyRelationTest {
    Person kingShan,queenAnga,chit,amba,ish,vich;

    @Before
    public void loadTestData(){
        kingShan = new Person("king shan", Gender.MALE);
        queenAnga = new Person("queen anga",Gender.FEMALE);
        kingShan.setSpouse(queenAnga);
        chit = new Person("chit",Gender.MALE);
        amba=new Person("amba",Gender.FEMALE);
        chit.setSpouse(amba);
        chit.linkToFather(kingShan);
        chit.linkToMother(queenAnga);
        ish = new Person("ish",Gender.MALE);
        ish.linkToMother(queenAnga);
        ish.linkToFather(kingShan);

        vich= new Person("vich",Gender.MALE);
        vich.linkToFather(kingShan);
        vich.linkToMother(queenAnga);
    }


    @Test
    public void areCouples(){
        assert(kingShan.getWife().equals(queenAnga));
        assert(queenAnga.getHusband().equals(kingShan));
    }

    @Test
    public void ChitIshVichAreSiblings(){
        List<Person> children = chit.getFather().getChildren();
        assert (children.containsAll(Arrays.asList(ish,vich)));
    }



}